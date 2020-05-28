import java.util.*;
import java.io.*;

public class Woodcutter {

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
		long[][] a = new long[n][2];
		long dp[] = new long[n];

		for (int i = 0; i < n; ++i) {
			a[i][0] = t.nextLong();
			a[i][1] = t.nextLong();
		}

		dp[0] = 1;
		long cur = a[0][0];

		for (int i = 1; i < n - 1; ++i) {
			if (a[i][0] - cur > a[i][1]) {
				cur = a[i][0];
				dp[i] = dp[i - 1] + 1;
			} else if (a[i + 1][0] - a[i][0] > a[i][1]) {
				cur = a[i][1] + a[i][0];
				dp[i] = dp[i - 1] + 1;
			} else {
				cur = a[i][0];
				dp[i] = dp[i - 1];
			}
		}

		if (n > 1)
			dp[n - 1] = dp[n - 2] + 1;

		o.println(dp[n - 1]);

		o.flush();
		o.close();
	}
}