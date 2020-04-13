
import java.util.*;
import java.io.*;

public class OR_In_Matrix {

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
		int m = t.nextInt();
		int n = t.nextInt();
		int[][] a = new int[m][n];
		int[][] b = new int[m][n];

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				a[i][j] = t.nextInt();
				b[i][j] = 1;
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 0) {
					for (int k = 0; k < n; k++) {
						b[i][k] = 0;
					}

					for (int k = 0; k < m; k++) {
						b[k][j] = 0;
					}
				}
			}
		}

		boolean res = true;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					res = false;

					for (int k = 0; k < n; k++) {
						if (b[i][k] == 1) {
							res = true;
						}
					}

					for (int k = 0; k < m; k++) {
						if (b[k][j] == 1) {
							res = true;
						}
					}
				}

				if (!res) {
					break;
				}
			}

			if (!res)
				break;
		}

		if (res) {
			o.println("YES");

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					o.print(b[i][j] + " ");
				}

				o.println();
			}
		} else
			o.println("NO");

		o.flush();
		o.close();
	}
}
