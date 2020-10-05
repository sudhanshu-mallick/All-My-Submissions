import java.util.*;
import java.io.*;

public class Lonely_Numbers {

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

	static boolean[] prime;

	public static void SieveOfEratosthenes(int n) {

		prime = new boolean[n + 1];

		for (int i = 0; i < n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p * p; i <= n; i += p)
					prime[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int tst = t.nextInt();
		SieveOfEratosthenes(1000000);
		int[] dp = new int[1000001];

		for (int i = 1; i < dp.length; ++i) {
			dp[i] = dp[i - 1] + (prime[i] ? 1 : 0);
		}

		while (tst-- > 0) {
			int n = t.nextInt();
			int x = (int) Math.sqrt(n);

			o.println(dp[n] - dp[x] + 1);
		}

		o.flush();
		o.close();
	}
}