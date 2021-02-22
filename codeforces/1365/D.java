import java.util.*;
import java.io.*;

public class Solve_The_Maze {

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
			char ch[][] = new char[m][n];
			int dir[] = { 1, 0, -1, 0, 1 };
			boolean[][] canBeVis = new boolean[m][n];
			boolean flag = true;

			for (int i = 0; i < m; ++i) {
				String s = t.next();

				for (int j = 0; j < n; ++j)
					ch[i][j] = s.charAt(j);
			}

			for (int i = 0; i < m; ++i)
				for (int j = 0; j < n; ++j)
					if (ch[i][j] == 'B') {
						for (int k = 0; k < 4; ++k) {
							int x = i + dir[k];
							int y = j + dir[k + 1];

							if (x >= 0 && x < m && y >= 0 && y < n) {
								if (ch[x][y] == '.')
									ch[x][y] = '#';
								else if (ch[x][y] == 'G')
									flag = false;
							}
						}
					}

			Queue<int[]> queue = new LinkedList<>();

			if (ch[m - 1][n - 1] == '.' || ch[m - 1][n - 1] == 'G') {
				queue.add(new int[] { m - 1, n - 1 });

				canBeVis[m - 1][n - 1] = true;
			}

			while (!queue.isEmpty()) {
				int[] a = queue.remove();

				for (int i = 0; i < 4; ++i) {
					int x = a[0] + dir[i];
					int y = a[1] + dir[i + 1];

					if (x >= 0 && x < m && y >= 0 && y < n && (ch[x][y] == '.' || ch[x][y] == 'G') && !canBeVis[x][y]) {
						canBeVis[x][y] = true;

						queue.add(new int[] { x, y });
					}
				}
			}

			for (int i = 0; i < m; ++i)
				for (int j = 0; j < n; ++j)
					if (ch[i][j] == 'G' && !canBeVis[i][j])
						flag = false;

			o.println(flag ? "Yes" : "No");
		}

		o.flush();
		o.close();
	}
}