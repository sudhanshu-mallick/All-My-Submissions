import java.util.*;
import java.io.*;

public class Districts_Connections {

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
			int[] a = new int[n];
			boolean flag = false;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();
			}

			int rep = a[0];

			for (int i = 1; i < n; ++i) {
				if (a[i] != rep) {
					flag = true;

					break;
				}
			}

			if (flag) {
				o.println("YES");

				int cur = a[0];
				int idx = -1;

				for (int i = 1; i < n; ++i) {
					if (a[i] != cur) {
						o.println((i + 1) + " 1");

						idx = i + 1;
					}
				}

				for (int i = 1; i < n; ++i) {
					if (a[i] == cur) {
						o.println((i + 1) + " " + idx);
					}
				}

			} else {
				o.println("NO");
			}
		}

		o.flush();
		o.close();
	}
}
