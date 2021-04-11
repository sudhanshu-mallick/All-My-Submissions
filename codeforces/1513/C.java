import java.util.*;
import java.io.*;

public class Add_One {

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
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();
		long[][] dp = new long[300000][10];
		dp[0][0] = 1;
		long mod = 1000000007;
		long sum[] = new long[dp.length];

		for (int i = 1; i < dp.length; ++i) {
			for (int j = 1; j < 10; ++j)
				dp[i][j] = dp[i - 1][j - 1];

			dp[i][1] = (dp[i - 1][9] + dp[i][1]) % mod;
			dp[i][0] = (dp[i - 1][9] + dp[i][0]) % mod;
		}

		for (int i = 0; i < dp.length; ++i) {
			for (int j = 0; j < 10; ++j)
				sum[i] = (sum[i] + dp[i][j]) % mod;
		}
//
//		for (int i = 0; i < 20; ++i) {
//			for (int j = 0; j < 10; ++j)
//				o.print(dp[i][j] + " ");
//
//			o.println();
//		}

		while (test-- > 0) {
			String s = Integer.toString(t.nextInt());
			int m = t.nextInt();
			long ans = 0;
			long[] count = new long[10];

			for (char c : s.toCharArray())
				++count[c - '0'];

			for (int i = 0; i < 10; ++i) {
				long toAdd = (count[i] * sum[i + m]) % mod;
				ans = (ans + toAdd) % mod;
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}