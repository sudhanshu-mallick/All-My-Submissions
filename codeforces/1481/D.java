import java.util.*;
import java.io.*;

public class AB_Graph {

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
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int m = t.nextInt();
			char ch[][] = new char[n][n];
			boolean flag = false;

			for (int i = 0; i < n; ++i) {
				String s = t.next();

				for (int j = 0; j < n; ++j)
					ch[i][j] = s.charAt(j);
			}

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (i != j && ch[i][j] == ch[j][i]) {
						o.println("YES");

						int k = 0;

						while (k <= m) {
							if ((k & 1) == 0)
								o.print(i + 1 + " ");
							else
								o.print(j + 1 + " ");

							++k;
						}

						flag = true;
						break;
					}
				}

				if (flag)
					break;
			}

			if (!flag) {
				if ((m & 1) == 1) {
					o.println("YES");

					int k = 0;

					while (k <= m) {
						if ((k & 1) == 0)
							o.print("1 ");
						else
							o.print("2 ");

						++k;
					}
				} else if (n == 2) {
					o.print("NO");
				} else {
					o.println("YES");

					int x = 0, y = 0, z = 0;

					if (ch[0][1] == ch[1][2]) {
						x = 1;
						y = 2;
						z = 3;
					} else if (ch[1][2] == ch[2][0]) {
						x = 2;
						y = 3;
						z = 1;
					} else {
						x = 3;
						y = 1;
						z = 2;
					}

					m >>= 1;

					if ((m & 1) == 1) {
						for (int i = 0; i < m; ++i) {
							if ((i & 1) == 0)
								o.print(x + " ");
							else
								o.print(y + " ");
						}

						o.print(y + " ");

						for (int i = 0; i < m; ++i) {
							if ((i & 1) == 1)
								o.print(y + " ");
							else
								o.print(z + " ");
						}
					} else {
						for (int i = 0; i < m; ++i) {
							if ((i & 1) == 0)
								o.print(y + " ");
							else
								o.print(x + " ");
						}

						o.print(y + " ");

						for (int i = 0; i < m; ++i) {
							if ((i & 1) == 1)
								o.print(y + " ");
							else
								o.print(z + " ");
						}
					}
				}

			}

			o.println();
		}

		o.flush();
		o.close();
	}
}