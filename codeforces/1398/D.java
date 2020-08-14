import java.util.*;
import java.io.*;

public class Colored_Rectangles {

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
		int x = t.nextInt();
		int y = t.nextInt();
		int z = t.nextInt();
		long[] a = new long[x];
		long[] b = new long[y];
		long[] c = new long[z];

		for (int i = 0; i < x; ++i)
			a[i] = t.nextLong();

		for (int i = 0; i < y; ++i)
			b[i] = t.nextLong();

		for (int i = 0; i < z; ++i)
			c[i] = t.nextLong();

		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);

		ans = 0;
		dp = new long[x + 1][y + 1][z + 1];

		fun(a, b, c, x - 1, y - 1, z - 1);

		o.println(dp[x][y][z]);

		o.flush();
		o.close();
	}

	private static long ans;
	private static long[][][] dp;

	private static long fun(long a[], long[] b, long[] c, int i, int j, int k) {
		if ((i < 0 && j < 0) || (i < 0 && k < 0) || (j < 0 && k < 0))
			return 0;

		if (dp[i + 1][j + 1][k + 1] != 0)
			return dp[i + 1][j + 1][k + 1];

		long ans = 0;

		if (i >= 0 && j >= 0 && k >= 0) {
			ans = Math.max(ans, a[i] * b[j] + fun(a, b, c, i - 1, j - 1, k));
			ans = Math.max(ans, b[j] * c[k] + fun(a, b, c, i, j - 1, k - 1));
			ans = Math.max(ans, c[k] * a[i] + fun(a, b, c, i - 1, j, k - 1));
			return dp[i + 1][j + 1][k + 1] = ans;
		} else if (i >= 0 && j >= 0) {
			ans = Math.max(ans, a[i] * b[j] + fun(a, b, c, i - 1, j - 1, k));
			return dp[i + 1][j + 1][k + 1] = ans;
		} else if (j >= 0 && k >= 0) {
			ans = Math.max(ans, b[j] * c[k] + fun(a, b, c, i, j - 1, k - 1));
			return dp[i + 1][j + 1][k + 1] = ans;
		} else if (i >= 0 && k >= 0) {
			ans = Math.max(ans, c[k] * a[i] + fun(a, b, c, i - 1, j, k - 1));
			return dp[i + 1][j + 1][k + 1] = ans;
		}

		return 0;
	}
}