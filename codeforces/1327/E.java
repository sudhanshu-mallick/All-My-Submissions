import java.util.*;
import java.io.*;

public class Count_The_Blocks {

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
		long n = t.nextLong();

		for (int i = 1; i <= n; i++) {
			long ans = 0;

			if (i == n) {
				ans = 10;
			} else if (i == n - 1) {
				ans = 2 * 10 * 9;
			} else {

				ans = 2 * 10 * 9 * pow(10, n - i - 1);
				ans %= mod;
				ans += (n - i - 1) * 9 * 9 * 10 * pow(10, n - i - 2);
				ans = ans % mod;
			}

			o.print(ans + " ");
		}

		o.flush();
		o.close();
	}

	public static long mod = 998244353;

	private static long pow(long x, long n) {
		long ans = 1;

		if (n == 0)
			return 1;

		ans = pow(x, n / 2) % mod;
		ans *= ans;
		ans %= mod;

		if ((n & 1) == 1) {
			ans *= x;
			ans %= mod;
		}

		return ans;
	}
}