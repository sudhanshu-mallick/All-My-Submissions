import java.util.*;
import java.io.*;

public class Array_Walk {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int k = t.nextInt();
			int z = t.nextInt();
			int[] a = new int[n];
			int[] dp = new int[n + 1];

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();
				dp[i + 1] = dp[i] + a[i];
			}

			int max = dp[k + 1];
			int i = 1;

			while (i <= k) {
				int req = k - i;
				int chance = Math.min(req, z << 1);
				int sum = 0;
				int rev = a[i] + a[i - 1];
				sum = rev * (chance >> 1) + a[i - 1] * (chance & 1);
				sum += dp[i + 1];
				int left = req - chance;
				sum += dp[i + 1 + left] - dp[i + 1];
				max = Math.max(max, sum);
				++i;
			}

			o.println(max);
		}

		o.flush();
		o.close();
	}
}
