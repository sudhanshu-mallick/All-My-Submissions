import java.io.*;
import java.util.*;

public class AB_Matrix {

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
			int m = t.nextInt();
			int x = t.nextInt();
			int y = t.nextInt();

			if (n * x != m * y)
				o.println("NO");
			else {
				int[][] a = new int[n][m];
				int cur = 0;

				for (int i = 0; i < m; ++i) {
					for (int j = 0; j < y; ++j) {
						a[cur][i] = 1;
						cur = (cur + 1) % n;
					}
				}

				o.println("YES");

				for (int i = 0; i < n; ++i) {
					for (int j = 0; j < m; ++j)
						o.print(a[i][j]);

					o.println();
				}

			}
		}

		o.flush();
		o.close();
	}
}