import java.util.*;
import java.io.*;

public class Dubious_Crypto {

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
			long l = t.nextLong();
			long r = t.nextLong();
			long m = t.nextLong();

			for (long i = l; i <= r; ++i) {
				long x = m / i;
				long y = x + 1;
				long q1 = (m - x * i);
				long q2 = m - y * i;

				if (x > 0 && q1 <= r - l && q1 >= l - r) {
					o.print(i + " ");

					if (q1 >= 0l)
						o.print(r + " " + (r - q1));
					else
						o.print(l + " " + (l - q1));

					o.println();
					break;
				}

				if (q2 <= r - l && q2 >= l - r) {
					o.print(i + " ");

					if (q2 >= 0l)
						o.print(r + " " + (r - q2));
					else
						o.print(l + " " + (l - q2));

					o.println();
					break;
				}
			}
		}

		o.flush();
		o.close();
	}
}