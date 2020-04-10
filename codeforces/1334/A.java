import java.util.*;
import java.io.*;

public class Level_Statictics {

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

		while (test-- > 0) {
			int n = t.nextInt();
			int[][] a = new int[2][n];
			boolean flag = true;

			for (int i = 0; i < n; ++i) {
				a[0][i] = t.nextInt();
				a[1][i] = t.nextInt();
			}

			if (a[0][0] < a[1][0])
				flag = false;

			if (flag) {
				for (int i = 1; i < n; ++i) {
					if (a[0][i] >= a[0][i - 1] && a[1][i] >= a[1][i - 1] && a[0][i] >= a[1][i]
							&& a[0][i] - a[0][i - 1] >= a[1][i] - a[1][i - 1]) {

					} else {
						flag = false;
						break;
					}
				}

			}

			if (flag)
				o.println("YES");
			else
				o.println("NO");

		}

		o.flush();
		o.close();
	}
}