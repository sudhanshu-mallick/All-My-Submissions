import java.util.*;
import java.io.*;

public class Plus_From_Picture {

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
		char[][] a = new char[m][n];

		for (int i = 0; i < m; ++i) {
			String s = t.next();

			for (int j = 0; j < n; ++j)
				a[i][j] = s.charAt(j);
		}

		int x = 0, y = 0;

		for (int i = 1; i < m - 1; ++i) {
			for (int j = 1; j < n - 1; ++j) {
				if (a[i][j] == '*') {
					if (a[i][j + 1] == '*' && a[i][j - 1] == '*' && a[i + 1][j] == '*' && a[i - 1][j] == '*') {
						x = i;
						y = j;
						break;
					}
				}
			}
		}

		if (x != 0 && y != 0) {
			int l = 0, r = n - 1, u = 0, d = m - 1;
			boolean f = true;

			for (int i = y - 1; i >= 0; --i) {
				if (a[x][i] != '*') {
					l = i + 1;
					break;
				}
			}

			for (int i = y + 1; i < n; ++i) {
				if (a[x][i] != '*') {
					r = i - 1;
					break;
				}
			}

			for (int i = x - 1; i >= 0; --i) {
				if (a[i][y] != '*') {
					u = i + 1;
					break;
				}
			}

			for (int i = x + 1; i < m; ++i) {
				if (a[i][y] != '*') {
					d = i - 1;
					break;
				}
			}

			for (int i = 0; i < m; ++i)
				for (int j = 0; j < n; ++j) {
					if (a[i][j] == '*') {
						if (i == x || j == y) {
							if (i == x) {
								if (j > r || j < l)
									f = false;
							}

							else {
								if (i < u || i > d)
									f = false;
							}
						} else {
							f = false;
						}
					}
				}

			if (f)
				o.println("YES");
			else
				o.println("NO");
		} else {
			o.println("NO");
		}
		o.flush();
		o.close();
	}
}