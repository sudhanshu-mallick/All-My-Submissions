import java.util.*;
import java.io.*;

public class Anti_Sudoku {

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
		int[][] a = new int[9][9];

		while (test-- > 0) {
			for (int i = 0; i < 9; ++i) {
				String s = t.next();

				for (int j = 0; j < 9; ++j)
					a[i][j] = Integer.parseInt(s.charAt(j) + "");
			}

			int p = 0;

//			for (int i = 0; i < 9; ++i) {
//				for (int j = 0; j < 9; ++j) {
//					int x = p / 3;
//					int y = p % 3;
//
//					if (i == x && y == j) {
//						a[i][j] = a[i][j] == 9 ? 1 : a[i][j] + 1;
//						p++;
//					}
//				}
//			}

			p = a[0][0];
			a[0][0] = p == 9 ? 1 : p + 1;
			p = a[1][3];
			a[1][3] = p == 9 ? 1 : p + 1;
			p = a[2][6];
			a[2][6] = p == 9 ? 1 : p + 1;
			p = a[3][1];
			a[3][1] = p == 9 ? 1 : p + 1;
			p = a[4][4];
			a[4][4] = p == 9 ? 1 : p + 1;
			p = a[5][7];
			a[5][7] = p == 9 ? 1 : p + 1;
			p = a[6][2];
			a[6][2] = p == 9 ? 1 : p + 1;
			p = a[7][5];
			a[7][5] = p == 9 ? 1 : p + 1;
			p = a[8][8];
			a[8][8] = p == 9 ? 1 : p + 1;

			for (int i = 0; i < 9; ++i) {
				for (int j = 0; j < 9; ++j)
					o.print(a[i][j]);

				o.println();
			}
		}

		o.flush();
		o.close();
	}
}