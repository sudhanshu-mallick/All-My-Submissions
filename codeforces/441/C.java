import java.util.*;
import java.io.*;

public class Valera_And_Tubes {

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
		int k = t.nextInt();
		int i = 1, j = 1;
		int cur = m * n - 2 * (k - 1);

		while (k > 1) {
			o.print("2 ");

			int x1 = i, y1 = j;

			if ((i & 1) == 1) {
				if (j == n) {
					++i;
					j = n;
				} else {
					++j;
				}
			} else {
				if (j == 1) {
					++i;
					j = 1;
				} else {
					--j;
				}
			}

			int x2 = i, y2 = j;

			if ((i & 1) == 1) {
				if (j == n) {
					++i;
					j = n;
				} else {
					++j;
				}
			} else {
				if (j == 1) {
					++i;
					j = 1;
				} else {
					--j;
				}
			}

			o.println(x1 + " " + y1 + " " + x2 + " " + y2);

			--k;
		}

		o.print(cur + " ");

		while (i <= m) {
			int x1 = i, y1 = j;

			if ((i & 1) == 1) {
				if (j == n) {
					++i;
					j = n;
				} else {
					++j;
				}
			} else {
				if (j == 1) {
					++i;
					j = 1;
				} else {
					--j;
				}
			}

			o.print(x1 + " " + y1 + " ");
		}

		o.flush();
		o.close();
	}
}