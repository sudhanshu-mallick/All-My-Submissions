import java.util.*;
import java.io.*;

public class Nice_Matrix {

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
			int m = t.nextInt();
			int n = t.nextInt();
			int[][] a = new int[m][n];
			long ans = 0;
			for (int i = 0; i < m; ++i)
				for (int j = 0; j < n; ++j)
					a[i][j] = t.nextInt();

			for (int i = 0; i < m / 2; ++i) {
				for (int j = 0; j < n / 2; ++j) {
					int[] b = new int[4];
					b[0] = a[i][j];
					b[1] = a[m - i - 1][j];
					b[2] = a[i][n - j - 1];
					b[3] = a[m - i - 1][n - j - 1];

					Arrays.sort(b);
					ans += b[1] - b[0] + b[2] - b[1] + b[3] - b[1];
				}
			}

			if ((m & 1) == 1) {
				for (int i = 0; i < n / 2; ++i)
					ans += Math.abs(a[m / 2][i] - a[m / 2][n - i - 1]);
			}

			if ((n & 1) == 1) {
				for (int i = 0; i < m / 2; ++i) {
					ans += Math.abs(a[i][n / 2] - a[m - i - 1][n / 2]);
				}
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}