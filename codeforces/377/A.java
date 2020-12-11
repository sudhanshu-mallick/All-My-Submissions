import java.util.*;
import java.io.*;

public class Maze {

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
		char ch[][] = new char[m][n];
		int x = -1, y = -1;
		int free = 0;
		boolean vis[][] = new boolean[m][n];

		for (int i = 0; i < m; ++i) {
			String s = t.next();

			for (int j = 0; j < n; ++j) {
				ch[i][j] = s.charAt(j);

				if (ch[i][j] == '.') {
					free++;

					if (x == -1) {
						x = i;
						y = j;
					}
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { x, y });

		while (free > k) {
			int[] a = queue.remove();
			--free;
			x = a[0];
			y = a[1];
			ch[x][y] = 'f';

			if (x + 1 < m && ch[x + 1][y] == '.' && !vis[x + 1][y]) {
				vis[x + 1][y] = true;

				queue.add(new int[] { x + 1, y });
			}

			if (y + 1 < n && ch[x][y + 1] == '.' && !vis[x][y + 1]) {
				vis[x][y + 1] = true;

				queue.add(new int[] { x, y + 1 });
			}

			if (x > 0 && ch[x - 1][y] == '.' && !vis[x - 1][y]) {
				vis[x - 1][y] = true;

				queue.add(new int[] { x - 1, y });
			}

			if (y > 0 && ch[x][y - 1] == '.' && !vis[x][y - 1]) {
				vis[x][y - 1] = true;

				queue.add(new int[] { x, y - 1 });
			}
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (ch[i][j] == '.')
					o.print("X");
				else if (ch[i][j] == 'f')
					o.print(".");
				else
					o.print(ch[i][j]);
			}

			o.println();
		}

		o.flush();
		o.close();
	}
}