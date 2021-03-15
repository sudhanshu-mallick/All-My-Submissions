import java.util.*;
import java.io.*;

public class Maximum_Absurdity {

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
		int k = t.nextInt();
		long[] a = new long[n];
		long[][] dp = new long[n - k + 1][2];
		long ans = 0;
		long A = -1, B = -1;

		for (int i = 0; i < dp.length; ++i)
			dp[i][1] = i;

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextLong();

			if (i < k)
				dp[0][0] += a[i];
			else
				dp[i - k + 1][0] = dp[i - k][0] - a[i - k] + a[i];
		}

		int i = dp.length - 2;

		while (i >= 0) {
			if (i > dp.length - 1 - k) {
				if (dp[i][0] < dp[i + 1][0]) {
					dp[i][0] = dp[i + 1][0];
					dp[i][1] = dp[i + 1][1];
				}
			} else {
				if (ans <= dp[i][0] + dp[i + k][0]) {
					ans = dp[i][0] + dp[i + k][0];
					A = dp[i][1] + 1;
					B = dp[i + k][1] + 1;
				}

				if (dp[i][0] < dp[i + 1][0]) {
					dp[i][0] = dp[i + 1][0];
					dp[i][1] = dp[i + 1][1];
				}
			}

			--i;
		}

		o.println(A + " " + B);

		o.flush();
		o.close();
	}
}