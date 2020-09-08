import java.util.*;
import java.io.*;

public class Nekos_Maze_Game {

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
		int n = t.nextInt();
		boolean vis[][] = new boolean[2][n];
		int q = t.nextInt();
		int diag = 0, side = 0;

		while (q-- > 0) {
			int x = t.nextInt() - 1;
			int y = t.nextInt() - 1;

			if (vis[x][y]) {
				if (y > 0 && vis[1 - x][y - 1])
					diag--;

				if (y < n - 1 && vis[1 - x][y + 1])
					diag--;

				if (vis[1 - x][y])
					side--;

				vis[x][y] = false;
			} else {
				if (y > 0 && vis[1 - x][y - 1])
					diag++;

				if (y < n - 1 && vis[1 - x][y + 1])
					diag++;

				if (vis[1 - x][y])
					side++;

				vis[x][y] = true;
			}

			if (side + diag > 0)
				o.println("No");
			else
				o.println("Yes");
		}

		o.flush();
		o.close();
	}
}