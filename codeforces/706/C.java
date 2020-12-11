import java.util.*;
import java.io.*;

public class Hard_Problem {

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
		long[] cost = new long[n];
		String[] str = new String[n];
		long[][] dp = new long[n][2];
		long MAX = (long) 10e16;

		for (int i = 0; i < n; ++i) {
			cost[i] = t.nextLong();
		}

		for (int i = 0; i < n; ++i) {
			str[i] = t.next();
		}

		dp[0][1] = cost[0];
		boolean flag = true;

		for (int i = 1; i < n; ++i) {
			long v1 = MAX, v2 = MAX, v3 = MAX, v4 = MAX;
			dp[i][0] = dp[i][1] = MAX;

			if (dp[i - 1][0] != MAX) {
				StringBuilder x = new StringBuilder(str[i]);
				StringBuilder y = new StringBuilder(str[i - 1]);

				if (x.compareTo(y) >= 0) {
					v1 = 0;
					dp[i][0] = Math.min(dp[i - 1][0], dp[i][0]);
				}

				x = x.reverse();

				if (x.compareTo(y) >= 0) {
					v2 = cost[i];
					dp[i][1] = Math.min(dp[i - 1][0] + cost[i], dp[i][1]);
				}
			}

			if (dp[i - 1][1] != MAX) {
				StringBuilder x = new StringBuilder(str[i]);
				StringBuilder y = new StringBuilder(str[i - 1]);
				y = y.reverse();

				if (x.compareTo(y) >= 0) {
					v3 = 0;
					dp[i][0] = Math.min(dp[i - 1][1], dp[i][0]);
				}

				x = x.reverse();

				if (x.compareTo(y) >= 0) {
					v4 = cost[i];
					dp[i][1] = Math.min(dp[i - 1][1] + cost[i], dp[i][1]);
				}
			}

			if (dp[i][0] == MAX && dp[i][1] == MAX) {
				flag = false;
				break;
			}
		}

		if (flag)
			o.println(Math.min(dp[n - 1][0], dp[n - 1][1]));
		else
			o.println("-1");

		o.flush();
		o.close();
	}
}