import java.util.*;
import java.io.*;

public class Jeopardy {

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
		int m = t.nextInt();
		long[] a = new long[n];
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextLong();

			set.add(i);
		}

		long[] auction = new long[m];

		for (int i = 0; i < m; ++i) {
			int idx = t.nextInt() - 1;
			auction[i] = a[idx];

			set.remove(idx);
		}

		long sum = 0;

		if (set.size() > 0) {
			for (int i : set) {
				sum += a[i];
			}
		}

		shuffle(auction);
		Arrays.sort(auction);

		int i = m - 1;

		while (i >= 0) {
			if (auction[i] > sum) {
				sum += auction[i];
			} else {
				sum = sum << 1;
			}
			
			--i;
		}

		o.println(sum);

		o.flush();
		o.close();
	}
}