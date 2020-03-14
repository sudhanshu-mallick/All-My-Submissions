import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Team {

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
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int m = t.nextInt(), n = t.nextInt();
		StringBuilder s = new StringBuilder();

		if (n < m - 1 || n > 2 * m + 2) {
			o.println(-1);
		} else {
			while (n > m && n > 0 && m > 0) {
				n -= 2;
				m--;

				s.append("110");
			}

			if (m == 0) {
				while (n > 0) {
					s.append("1");
					n--;
				}
			}

			if (n == m) {
				while (n > 0) {
					m--;
					n--;

					s.append("10");
				}
			}

			if (m > n) {
				while (m > 0 && n > 0) {
					m--;
					n--;

					s.append("01");
				}

				s.append("0");
			}

			o.println(s);
		}

		o.flush();
		o.close();
	}

}
