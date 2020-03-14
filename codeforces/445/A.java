import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DZY_Loves_Chessboard {

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
		int m = t.nextInt(), n = t.nextInt();
		char[][] a = new char[m][n];

		for (int i = 0; i < m; i++) {
			String s = t.nextLine();
			for (int j = 0; j < n; j++) {
				a[i][j] = s.charAt(j);

				if (i % 2 == 0) {
					if (a[i][j] == '-') {

					} else {
						if (j % 2 == 0)
							a[i][j] = 'B';
						else
							a[i][j] = 'W';
					}
				} else {
					if (a[i][j] == '-') {

					} else {
						if (j % 2 == 1)
							a[i][j] = 'B';
						else
							a[i][j] = 'W';
					}
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				o.print(a[i][j]);
			}
			o.println();
		}

		o.flush();
		o.close();
	}

}
