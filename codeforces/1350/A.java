import java.util.*;
import java.io.*;

public class Orac_And_Factors {

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
			long k = t.nextLong();

			if ((n & 1) == 0) {
				n += k * 2;
			} else {
				int f = 0;
				for (long i = 3; i * i <= n; ++i) {
					if (n % i == 0) {
						n += i;
						f = 1;
						break;
					}
				}

				if (f == 0)
					n += n;

				n += (k - 1) * 2;
			}

			o.println(n);
		}

		o.flush();
		o.close();
	}
}