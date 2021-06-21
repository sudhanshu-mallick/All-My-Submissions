import java.util.*;
import java.io.*;

public class Stable_Groups {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}

	public static void shuffle(long[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(long[] a, int i, int j) {
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt();
		long k = t.nextLong();
		long x = t.nextLong();
		long[] a = new long[n];
		List<Long> groups = new ArrayList<>();

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		shuffle(a);

		long prev = a[0];
		int i = 0;

		while (i < n) {
			if (prev + x < a[i])
				groups.add((a[i] - prev + x - 1) / x - 1);

			prev = a[i];
			++i;
		}

		Collections.sort(groups);

		int size = groups.size() + 1;
		i = 0;

		while (i < groups.size()) {
			if (groups.get(i) <= k) {
				--size;
				k -= groups.get(i);
				++i;
			} else
				break;
		}

		o.println(size);
		o.flush();
		o.close();
	}
}