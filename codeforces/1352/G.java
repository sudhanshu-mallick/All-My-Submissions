import java.util.*;
import java.io.*;

public class Special_Permutation {
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

			if (n <= 3) {
				o.println("-1");
			} else {
				if ((n & 1) == 1) {
					int cur = 1;

					while (cur <= n) {
						o.print(cur + " ");
						cur += 2;
					}

					n -= (n / 2) + 1;
					cur -= 2;

					o.print((cur - 3) + " " + (cur - 1) + " ");
					n -= 2;

					if (n >= 1) {
						o.print(cur - 5 + " ");
						n--;
						cur = cur - 5;

						while (n-- > 0) {
							o.print(cur - 2 + " ");
							cur -= 2;
						}
					}

					o.println();

				} else {
					int cur = 2;

					while (cur <= n) {
						o.print(cur + " ");
						cur += 2;
					}

					n -= (n / 2);
					cur -= 2;

					o.print((cur - 3) + " " + (cur - 1) + " ");
					n -= 2;

					if (n >= 1) {
						o.print(cur - 5 + " ");
						n--;
						cur=cur-5;

						while (n-- > 0) {
							o.print(cur - 2 + " ");
							cur -= 2;
						}
					}

					o.println();
				}
			}
		}

		o.flush();
		o.close();
	}
}