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

		while (test-- > 0) {
			int n = t.nextInt();
			int k = t.nextInt();
			int t1 = k / n;
			int t2 = t1 + (k % n == 0 ? 0 : 1);
			int ans = (t1 == t2) ? 0 : 2;
			int[][] ar = new int[n][n];
			int a = n * t1 + n - k;
			int b = n - a;
			int cur = 0;

			for (int i = 0; i < a; ++i) {
				for (int j = 0; j < t1; ++j) {
					ar[i][cur] = 1;
					cur = (cur + 1) % n;
				}
			}

			for (int i = a; i < n; ++i) {
				for (int j = 0; j < t2; ++j) {
					ar[i][cur] = 1;
					cur = (cur + 1) % n;
				}
			}

			o.println(ans);

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j)
					o.print(ar[i][j]);

				o.println();
			}

		}

		o.flush();
		o.close();
	}
}