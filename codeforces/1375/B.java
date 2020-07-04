import java.util.*;
import java.io.*;

public class Neighbour_Grid {

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
			boolean flag = true;

			for (int i = 0; i < m; ++i)
				for (int j = 0; j < n; ++j) {
					a[i][j] = t.nextInt();

					if (a[i][j] > 2 && ((i == 0 && j == 0) || (i == m - 1 && j == n - 1) || (i == 0 && j == n - 1)
							|| (i == m - 1 && j == 0))) {
						flag = false;
					} else if (a[i][j] > 3 && (i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
						flag = false;
					} else if (a[i][j] > 4) {
						flag = false;
					}
				}

			if (flag) {
				o.println("YES");

				for (int i = 0; i < m; ++i) {
					for (int j = 0; j < n; ++j) {
						if (((i == 0 && j == 0) || (i == m - 1 && j == n - 1) || (i == 0 && j == n - 1)
								|| (i == m - 1 && j == 0))) {
							o.print("2 ");
						} else if ((i == 0 || j == 0 || i == m - 1 || j == n - 1)) {
							o.print("3 ");
						} else {
							o.print("4 ");
						}
					}

					o.println();
				}
			} else
				o.println("NO");

		}

		o.flush();
		o.close();
	}
}