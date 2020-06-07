import java.util.*;
import java.io.*;

public class Trouble_Sort {

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
			int[][] a = new int[n][2];
			boolean r = true;

			for (int i = 0; i < n; ++i)
				a[i][0] = t.nextInt();

			for (int i = 0; i < n; ++i)
				a[i][1] = t.nextInt();

			for (int i = 1; i < n; ++i)
				if (a[i][0] < a[i - 1][0]) {
					r = false;
					break;
				}

			if (r) {
				o.println("Yes");
			} else {
				int c1 = 0, c2 = 0;

				for (int i = 0; i < n; ++i) {
					if (a[i][1] == 0)
						c1++;
					else
						c2++;
				}

				if (c1 > 0 && c2 > 0)
					o.println("Yes");
				else
					o.println("No");
			}
		}

		o.flush();
		o.close();
	}
}