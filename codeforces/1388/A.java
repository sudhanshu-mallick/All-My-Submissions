import java.util.*;
import java.io.*;

public class Captain_Flint_And_New_Recruitment {

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
			long n = t.nextLong();
			long a = 6, b = 10, c = 14, d = 15;
			Set<Long> set = new HashSet<>();

			if (n <= 30l) {
				o.println("NO");
			} else {
				o.println("YES");
				n -= 30;

				if (n != a && n != b && n != c) {
					o.println(a + " " + b + " " + c + " " + n);
				} else {
					if (n == a) {
						o.println("6 10 15 5");
					} else if (n == b) {
						o.println("6 10 15 9");
					} else {
						o.println("6 10 15 13");
					}
				}

			}
		}

		o.flush();
		o.close();
	}
}