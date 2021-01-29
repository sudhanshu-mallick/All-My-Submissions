import java.util.*;
import java.io.*;

public class Geometric_Progression {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt();
		long k = t.nextLong();
		Map<Long, Long> right = new HashMap<>();
		Map<Long, Long> left = new HashMap<>();
		long[] a = new long[n];
		long count = 0l;

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextLong();

			right.put(a[i], right.getOrDefault(a[i], 0l) + 1);
		}

		for (int i = 0; i < n; ++i) {
			if (right.get(a[i]) == 1)
				right.remove(a[i]);
			else
				right.put(a[i], right.get(a[i]) - 1);

			if (a[i] % k == 0) {
				long l = left.getOrDefault(a[i] / k, 0l);
				long r = right.getOrDefault(a[i] * k, 0l);
				count += l * r;
			}

			left.put(a[i], left.getOrDefault(a[i], 0l) + 1);
		}

		o.println(count);
		o.flush();
		o.close();
	}
}