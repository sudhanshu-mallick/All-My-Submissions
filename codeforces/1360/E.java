import java.io.*;
import java.util.*;

public class Polygon {

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
			int[][] a = new int[n][n];

			for (int i = 0; i < n; ++i) {
				String s = t.next();

				for (int j = 0; j < n; ++j)
					a[i][j] = s.charAt(j) - '0';
			}

			boolean f = true;

			for (int i = 0; i < n - 1; ++i) {
				for (int j = 0; j < n - 1; ++j) {
					if (a[i][j] == 1) {
						if (a[i][j + 1] == 0 && a[i + 1][j] == 0) {
							f = false;
							break;
						}
					}
				}
			}

			if (f)
				o.println("YES");
			else
				o.println("NO");
		}

		o.flush();
		o.close();
	}
}
