import java.util.*;
import java.io.*;

public class Cakewalk {

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
		int m = t.nextInt();
		int n = t.nextInt();
		char[][] ch = new char[m][n];
		int cnt = 0;

		for (int i = 0; i < m; ++i) {
			String s = t.next();

			for (int j = 0; j < n; ++j)
				ch[i][j] = s.charAt(j);
		}

		int x = 0, y = 0;

		if (ch[0][0] == '*')
			++cnt;

		while (true) {
			int[] dir = { 0, 1, 0 };
			boolean vis[][] = new boolean[m][n];
			Queue<int[]> queue = new LinkedList<>();
			vis[x][y] = true;
			int newX = x, newY = y;

			queue.add(new int[] { x, y });

			while (!queue.isEmpty()) {
				int[] a = queue.remove();
				boolean flag = false;

				for (int i = 0; i < 2; ++i) {
					int X = a[0] + dir[i];
					int Y = a[1] + dir[i + 1];

					if (X < m && Y < n && !vis[X][Y]) {
						vis[X][Y] = true;

						if (ch[X][Y] == '*') {
							newX = X;
							newY = Y;
							flag = true;
							break;
						}

						queue.add(new int[] { X, Y });
					}
				}

				if (flag)
					break;
			}

			if (x != newX || y != newY) {
				x = newX;
				y = newY;
				++cnt;
			} else
				break;

		}

		o.println(cnt);
		o.flush();
		o.close();
	}
}