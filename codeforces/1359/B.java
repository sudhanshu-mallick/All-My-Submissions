import java.util.*;
import java.io.*;

public class New_Theatre_Square {

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
			int x = t.nextInt();
			int y = t.nextInt();
			boolean one = (x * 2 <= y) ? true : false;
			char[][] ch = new char[m][n];

			for (int i = 0; i < m; ++i) {
				String s = t.next();

				for (int j = 0; j < n; ++j) {
					ch[i][j] = s.charAt(j);
				}
			}

			if (one) {
				int count = 0;

				for (int i = 0; i < m; ++i) {
					for (int j = 0; j < n; ++j) {
						if (ch[i][j] == '.')
							count++;
					}
				}

				o.println(count * x);
			} else {
				int c1 = 0, c2 = 0;

				for (int i = 0; i < m; ++i) {
					for (int j = 0; j < n; ++j) {
						char ch1 = ch[i][j], ch2 = (j + 1 < n) ? ch[i][j + 1] : '*';

						if (ch1 == ch2 && ch1 == '.') {
							c2++;
							j++;
						} else if (ch1 == '.')
							c1++;
					}
				}

				o.println(c1 * x + c2 * y);
			}

		}

		o.flush();
		o.close();
	}
}