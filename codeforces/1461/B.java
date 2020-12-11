import java.util.*;
import java.io.*;

public class Find_The_Spruce {

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
			char[][] ch = new char[m][n];

			for (int i = 0; i < m; ++i) {
				String s = t.next();

				for (int j = 0; j < n; ++j)
					ch[i][j] = s.charAt(j);
			}

			int[][] left = new int[m][n];
			int[][] right = new int[m][n];

			for (int i = 0; i < m; ++i) {
				int cnt = 0;

				for (int j = 0; j < n; ++j) {
					left[i][j] = cnt;

					if (ch[i][j] == '*')
						++cnt;
					else
						cnt = 0;
				}

				cnt = 0;

				for (int j = n - 1; j >= 0; --j) {
					right[i][j] = cnt;

					if (ch[i][j] == '*')
						++cnt;
					else
						cnt = 0;
				}
			}

			long ans = 0;

			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (ch[i][j] == '.')
						continue;

					int x = i;

					while (x < m) {
						if (ch[x][j] == '.')
							break;

						if (left[x][j] >= (x - i) && right[x][j] >= (x - i))
							++ans;
						else
							break;

						++x;
					}
				}
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}