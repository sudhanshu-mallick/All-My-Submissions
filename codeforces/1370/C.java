import java.util.*;
import java.io.*;

public class Number_Game {

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
		String a = "FastestFinger";
		String b = "Ashishgup";

		while (test-- > 0) {
			long n = t.nextLong();

			if ((n & 1) == 1) {
				if (n == 1)
					sb.append(a + "\n");
				else
					sb.append(b + "\n");
			} else {
				if (n == 2)
					sb.append(b + "\n");
				else {
					long cur = 0;

					while ((n & 1) == 0) {
						n = n >> 1;
						cur++;
					}

					if (n == 1) {
						sb.append(a + "\n");
					} else if (cur == 1) {
						boolean res = true;

						for (long i = 2; i * i <= n; ++i) {
							if (n % i == 0) {
								res = false;
								break;
							}
						}

						if (res)
							sb.append(a + "\n");
						else
							sb.append(b + "\n");

					} else {
						sb.append(b + "\n");
					}

				}
			}
		}

		o.println(sb);
		o.flush();
		o.close();
	}
}