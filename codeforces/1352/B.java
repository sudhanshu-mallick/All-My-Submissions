import java.util.*;
import java.io.*;

public class Same_Parity_Summands {
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

			if (k <= n) {
				int v1 = (n & 1);
				int v2 = (k & 1);

				if (v1 == 0 && v2 == 0) {
					o.println("YES");

					for (int i = 0; i < k - 1; ++i)
						o.print("1 ");

					o.print(n - k + 1);
				} else if (v1 == 0 && v2 == 1) {
					if (n >= 2 * k) {
						o.println("YES");

						for (int i = 0; i < k - 1; ++i)
							o.print("2 ");

						o.print(n - 2 * k + 2);
					} else
						o.print("NO");
				} else if (v1 == 1 && v2 == 0) {
					o.print("NO");
				} else {
					o.println("YES");

					for (int i = 0; i < k - 1; ++i)
						o.print("1 ");

					o.print(n - k + 1);
				}
			} else {
				o.print("NO");
			}

			o.println();
		}

		o.flush();
		o.close();
	}
}
