import java.util.*;
import java.io.*;

public class Grid_00100 {

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
		StringBuilder sb = new StringBuilder();

		while (test-- > 0) {
			int n = t.nextInt();
			int k = t.nextInt();
			if (k % n == 0)
				sb.append("0\n");
			else
				sb.append("2\n");

			int x = 0, y = 0;
			int a[][] = new int[n][n];

			while (k-- > 0) {
				a[x][y] = 1;
				x++;
				y = (y + 1) % n;

				if (x == n) {
					x = 0;
					y = (y + 1) % n;
				}
			}

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j)
					sb.append(a[i][j]);

				sb.append("\n");
			}
		}

		o.println(sb);
		o.flush();
		o.close();
	}
}