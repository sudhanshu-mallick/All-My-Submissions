import java.io.*;
import java.util.*;

public class Lose_It {

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
		int[] a = new int[n];
		int dp[] = new int[6];

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();

			if (a[i] == 4)
				dp[0]++;
			else if (a[i] == 8) {
				if (dp[0] > dp[1])
					dp[1]++;
			} else if (a[i] == 15) {
				if (dp[1] > dp[2])
					dp[2]++;
			} else if (a[i] == 16) {
				if (dp[2] > dp[3])
					dp[3]++;
			} else if (a[i] == 23) {
				if (dp[3] > dp[4])
					dp[4]++;
			} else if (a[i] == 42) {
				if (dp[4] > dp[5])
					dp[5]++;
			}
		}

//		System.out.println(dp[0] + " " + dp[1] + " " + dp[2] + " " + dp[3] + " " + dp[4] + " " + dp[5]);

		o.println(n - 6 * dp[5]);

		o.flush();
		o.close();
	}
}