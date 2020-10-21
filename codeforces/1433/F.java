import java.util.*;
import java.io.*;

public class Zero_Remainder_Sum {

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
		m = t.nextInt();
		n = t.nextInt();
		k = t.nextInt();
		a = new int[m][n];
		dp = new int[71][71][71][36];

		for (int i = 0; i < 71; ++i)
			for (int j = 0; j < 71; ++j)
				for (int k = 0; k < 71; ++k)
					for (int l = 0; l < 36; ++l)
						dp[i][j][k][l] = -1;

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				a[i][j] = t.nextInt();
			}
		}

		o.println(dp(0, 0, 0, n / 2));

		o.flush();
		o.close();
	}

	private static int[][] a;
	private static int m, n, k;
	private static int[][][][] dp;

	private static int dp(int x, int y, int rem, int left) {
		if (x == (m - 1) && (left == 0 || y == n)) {
			if (rem == 0)
				return 0;
			else
				return Integer.MIN_VALUE;
		}

		if (left == 0 || y == n)
			return dp[x][y][rem][left] = dp(x + 1, 0, rem, n / 2);

		if (dp[x][y][rem][left] != -1)
			return dp[x][y][rem][left];

		int mod = a[x][y] % k;
		int ans = Integer.MIN_VALUE;

		if (mod < rem) {
			ans = Math.max(ans, a[x][y] + dp(x, y + 1, rem - mod, left - 1));
		} else if (mod > rem) {
			ans = Math.max(ans, a[x][y] + dp(x, y + 1, k - mod + rem, left - 1));
		} else {
			ans = Math.max(ans, a[x][y] + dp(x, y + 1, 0, left - 1));
		}

		ans = Math.max(ans, dp(x, y + 1, rem, left));

		return dp[x][y][rem][left] = ans;
	}
}