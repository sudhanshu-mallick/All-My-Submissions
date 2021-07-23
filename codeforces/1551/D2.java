import java.util.*;
import java.io.*;

public class Domino {

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
			int m = t.nextInt();
			int n = t.nextInt();
			int k = t.nextInt();
			boolean flag = true;
			char[][] mat = new char[m][n];

			for (int i = 0; i < m; ++i)
				for (int j = 0; j < n; ++j)
					mat[i][j] = '?';

			if ((m & 1) == 1) {
				n >>= 1;
				flag = k >= n && (((k - n) & 1) == 0);

				if (flag) {
					k -= n;
					n <<= 1;
					int cur = 0;

					for (int j = 0; j < n; j += 2) {
						if (cur == 0)
							mat[0][j] = mat[0][j + 1] = 'a';
						else
							mat[0][j] = mat[0][j + 1] = 'b';

						cur ^= 1;
					}

					int i = 1, j = 0;

					while (k-- > 0) {
						if ((j >> 1) % 2 == 0) {
							if (i % 2 == 0)
								mat[i][j] = mat[i][j + 1] = 'a';
							else
								mat[i][j] = mat[i][j + 1] = 'b';
						} else {
							if (i % 2 == 0)
								mat[i][j] = mat[i][j + 1] = 'b';
							else
								mat[i][j] = mat[i][j + 1] = 'a';
						}

						++i;

						if (i == m) {
							i = 1;
							j += 2;
						}
					}

					int[] dir = { 1, 0, -1, 0, 1 };

					for (i = 0; i < m; ++i)
						for (j = 0; j < n; ++j) {
							if (mat[i][j] != '?')
								continue;

							Set<Character> set = new HashSet<>();

							for (k = 0; k < 4; ++k) {
								int x = i + dir[k];
								int y = j + dir[k + 1];

								if (x >= 0 && x < m && y >= 0 && y < n)
									set.add(mat[x][y]);
							}

							for (k = 0; k < 4; ++k) {
								int x = i + 1 + dir[k];
								int y = j + dir[k + 1];

								if (x >= 0 && x < m && y >= 0 && y < n)
									set.add(mat[x][y]);
							}

							char curChar = 'a';

							while (set.contains(curChar))
								++curChar;

							mat[i][j] = mat[i + 1][j] = curChar;
						}
				}
			} else if ((n & 1) == 1) {
				flag = (k & 1) == 0 && (k <= (m * n) / 2 - m / 2);

				if (flag) {
					int i = 0, j = 0;

					while (k-- > 0) {
						if ((j >> 1) % 2 == 0) {
							if (i % 2 == 0)
								mat[i][j] = mat[i][j + 1] = 'a';
							else
								mat[i][j] = mat[i][j + 1] = 'b';
						} else {
							if (i % 2 == 0)
								mat[i][j] = mat[i][j + 1] = 'b';
							else
								mat[i][j] = mat[i][j + 1] = 'a';
						}

						++i;

						if (i == m) {
							i = 0;
							j += 2;
						}
					}

					int[] dir = { 1, 0, -1, 0, 1 };

					for (i = 0; i < m; ++i)
						for (j = 0; j < n; ++j) {
							if (mat[i][j] != '?')
								continue;

							Set<Character> set = new HashSet<>();

							for (k = 0; k < 4; ++k) {
								int x = i + dir[k];
								int y = j + dir[k + 1];

								if (x >= 0 && x < m && y >= 0 && y < n)
									set.add(mat[x][y]);
							}

							for (k = 0; k < 4; ++k) {
								int x = i + 1 + dir[k];
								int y = j + dir[k + 1];

								if (x >= 0 && x < m && y >= 0 && y < n)
									set.add(mat[x][y]);
							}

							char curChar = 'a';

							while (set.contains(curChar))
								++curChar;

							mat[i][j] = mat[i + 1][j] = curChar;
						}
				}
			} else {
				flag = (k & 1) == 0;

				if (flag) {
					int i = 0, j = 0;

					while (k-- > 0) {
						if ((j >> 1) % 2 == 0) {
							if (i % 2 == 0)
								mat[i][j] = mat[i][j + 1] = 'a';
							else
								mat[i][j] = mat[i][j + 1] = 'b';
						} else {
							if (i % 2 == 0)
								mat[i][j] = mat[i][j + 1] = 'b';
							else
								mat[i][j] = mat[i][j + 1] = 'a';
						}

						++i;

						if (i == m) {
							i = 0;
							j += 2;
						}
					}

					int[] dir = { 1, 0, -1, 0, 1 };

					for (i = 0; i < m; ++i)
						for (j = 0; j < n; ++j) {
							if (mat[i][j] != '?')
								continue;

							Set<Character> set = new HashSet<>();

							for (k = 0; k < 4; ++k) {
								int x = i + dir[k];
								int y = j + dir[k + 1];

								if (x >= 0 && x < m && y >= 0 && y < n)
									set.add(mat[x][y]);
							}

							for (k = 0; k < 4; ++k) {
								int x = i + 1 + dir[k];
								int y = j + dir[k + 1];

								if (x >= 0 && x < m && y >= 0 && y < n)
									set.add(mat[x][y]);
							}

							char curChar = 'a';

							while (set.contains(curChar))
								++curChar;

							mat[i][j] = mat[i + 1][j] = curChar;
						}
				}
			}

			if (flag) {
				o.println("YES");

				for (int i = 0; i < m; ++i) {
					for (int j = 0; j < n; ++j)
						o.print(mat[i][j]);

					o.println();
				}
			} else
				o.println("NO");
		}

		o.flush();
		o.close();
	}
}