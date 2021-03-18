import java.util.*;
import java.io.*;

public class M_Arrays {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int m = t.nextInt();
			int[] a = new int[m];
			int count = 0;

			for (int i = 0; i < n; ++i)
				++a[t.nextInt() % m];

			if (a[0] > 0)
				++count;

			if ((m & 1) == 0 && a[m >> 1] > 0)
				++count;

			for (int i = 1; i < (m + 1) >> 1; ++i) {
				int min = Math.min(a[i], a[m - i]);
				int max = Math.max(a[i], a[m - i]);

				if (max == 0)
					continue;

				max -= (min + 1);
				++count;

				if (max > 0)
					count += max;
			}

			o.println(count);
		}

		o.flush();
		o.close();
	}
}