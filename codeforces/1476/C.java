import java.util.*;
import java.io.*;

public class Longest_Simple_Cycle {

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
			long[] c = new long[n];
			long[] a = new long[n];
			long[] b = new long[n];
			long[] dp = new long[n];

			for (int i = 0; i < n; ++i)
				c[i] = t.nextLong();

			for (int i = 0; i < n; ++i)
				a[i] = t.nextLong();

			for (int i = 0; i < n; ++i) {
				long x = t.nextLong();

				if (x < a[i]) {
					b[i] = a[i];
					a[i] = x;
				} else
					b[i] = x;
			}

			for (int i = 1; i < n; ++i) {
				if (a[i] == b[i]) {
					dp[i] = c[i] + 1;
				} else {
					dp[i] = Math.max(b[i] - a[i] + c[i] + 1, dp[i - 1] - b[i] + a[i] + 1 + c[i]);
				}
			}

			long max = 0;

			for (int i = 0; i < n; ++i)
				max = Math.max(max, dp[i]);

			o.println(max);
		}

		o.flush();
		o.close();
	}
}