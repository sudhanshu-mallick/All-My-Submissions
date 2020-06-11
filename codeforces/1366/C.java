
import java.util.*;
import java.io.*;

public class Palindromic_Paths {

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
			int[][] p = new int[m][n];
			int[][] a;
			int count = 0;

			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					p[i][j] = t.nextInt();
				}
			}

			if (m <= n)
				a = p;
			else {
				a = new int[n][m];

				for (int i = 0; i < m; ++i)
					for (int j = 0; j < n; ++j)
						a[j][i] = p[i][j];

				int temp = m;
				m = n;
				n = temp;
			}

			int I = m - 1;
			int J = n - 1;

			for (int i = 0; i < (m + n - 1) / 2; ++i) {
				int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

				int cur = i;
				for (int j = 0; j < Math.min(m, i + 1); ++j) {
					if (a[j][cur--] == 0)
						y1++;
					else
						x1++;
				}

				int q = J;

				for (int j = m - 1; j >= Math.max(0, I); --j) {
					if (a[j][q++] == 0)
						y2++;
					else
						x2++;
				}

				I--;
				J--;

				if (x1 + x2 > y1 + y2)
					count += y1 + y2;
				else
					count += x1 + x2;

//				System.out.println(x1 + " " + x2);
			}

			o.println(count);
		}

		o.flush();
		o.close();
	}
}
