import java.util.*;
import java.io.*;

public class George_And_Job {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt();
		int m = t.nextInt();
		int k = t.nextInt();
		long[] a = new long[n + 1];
		a[0] = 0;

		for (int i = 1; i <= n; ++i)
			a[i] = a[i - 1] + t.nextLong();

		long[][] dp = new long[k + 1][n + 1];

		for (int i = 1; i <= k; ++i) {
			for (int j = 1; j <= n; ++j) {

				if (j - m >= 0) {
					dp[i][j] = a[j] - a[j - m] + dp[i - 1][j - m];
				}

				dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
			}
		}

		o.println(dp[k][n]);

		o.flush();
		o.close();
	}
}