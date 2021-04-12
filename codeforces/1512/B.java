import java.util.*;
import java.io.*;

public class Almost_Rectangle {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(int[] a, int i, int j) {
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			char[][] ch = new char[n][n];
			int idx = 0;
			int[][] a = new int[4][2];

			for (int i = 0; i < n; ++i) {
				String s = t.next();

				for (int j = 0; j < n; ++j) {
					ch[i][j] = s.charAt(j);

					if (ch[i][j] == '*') {
						a[idx][0] = i;
						a[idx][1] = j;
						++idx;
					}
				}
			}

			if (a[0][0] == a[1][0] || a[0][1] == a[1][1]) {
				if (a[0][0] == a[1][0]) {
					if (a[0][0] > 0) {
						int x1 = 0, y1 = a[0][1];
						int x2 = 0, y2 = a[1][1];
						ch[x1][y1] = ch[x2][y2] = '*';
					} else {
						int x1 = n - 1, y1 = a[0][1];
						int x2 = n - 1, y2 = a[1][1];
						ch[x1][y1] = ch[x2][y2] = '*';
					}
				} else {
					if (a[1][1] > 0) {
						int y1 = 0, x1 = a[0][0];
						int y2 = 0, x2 = a[1][0];
						ch[x1][y1] = ch[x2][y2] = '*';
					} else {
						int y1 = n - 1, x1 = a[0][0];
						int y2 = n - 1, x2 = a[1][0];
						ch[x1][y1] = ch[x2][y2] = '*';
					}
				}
			} else {
				int x1 = a[0][0], y1 = a[1][1];
				int x2 = a[1][0], y2 = a[0][1];
				ch[x1][y1] = ch[x2][y2] = '*';
			}

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j)
					o.print(ch[i][j]);

				o.println();
			}
		}

		o.flush();
		o.close();
	}
}