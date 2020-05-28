import java.io.*;
import java.util.*;

public class Number_Of_Ways {

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
		long[] a = new long[n];
		long dp[] = new long[n];
		long sum = 0;

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextLong();
			sum += a[i];
		}

		if (sum % 3 == 0) {
			long cur = a[n - 1], ans = 0;

			if (a[n - 1] == sum / 3)
				dp[n - 1] = 1;

			for (int i = n - 2; i >= 0; --i) {
				cur += a[i];

				if (cur == sum / 3)
					dp[i] = 1 + dp[i + 1];
				else
					dp[i] = dp[i + 1];
			}

			cur = 0;

			for (int i = 0; i < n - 2; ++i) {
				cur += a[i];

				if (cur == sum / 3)
					ans += dp[i + 2];
			}

			o.println(ans);

		} else {
			o.println("0");
		}

		o.flush();
		o.close();
	}
}