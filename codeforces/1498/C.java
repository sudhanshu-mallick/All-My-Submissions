import java.util.*;
import java.io.*;

public class Planar_Reflections {

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
			int k = t.nextInt();
			long[][] dp = new long[k][n + 1];
			long mod = 1_000_000_007;

			if (k == 1) {
				o.println("1");
			} else {
				long ans = 1;

				for (int i = n; i >= 1; --i)
					dp[k - 1][i] = 1;

				for (int i = k - 2; i >= 1; --i) {
					boolean start = ((k - i) & 1) == 0;

					if (start) {
						for (int j = n - 1; j >= 1; --j)
							dp[i + 1][j] = (dp[i + 1][j] + dp[i + 1][j + 1]) % mod;

						for (int j = 1; j < n; ++j)
							dp[i][j] = dp[i + 1][j + 1];
					} else {
						for (int j = 2; j <= n; ++j)
							dp[i + 1][j] = (dp[i + 1][j - 1] + dp[i + 1][j]) % mod;

						for (int j = n; j > 1; --j)
							dp[i][j] = dp[i + 1][j - 1];
					}
				}

				for (int i = 2; i < k; ++i) {
					if (((k - i) & 1) == 1)
						ans = (ans + dp[i][1]) % mod;
					else
						ans = (ans + dp[i][n]) % mod;

				}

				for (int j = 1; j <= n; ++j)
					ans = (ans + dp[1][j]) % mod;

//				for (int i = 1; i < k; ++i) {
//					for (int j = 1; j <= n; ++j)
//						o.print(dp[i][j] + " ");
//
//					o.println();
//				}

				o.println(ans);
			}
		}

		o.flush();
		o.close();
	}
}