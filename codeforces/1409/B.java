
import java.util.*;
import java.io.*;

public class Minimum_Product {

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
			long a = t.nextLong();
			long b = t.nextLong();
			long x = t.nextLong();
			long y = t.nextLong();
			long n = t.nextLong();
			long v1 = Math.max(a - n, x);
			long v2 = Math.max(b - n, y);

			if (v1 < v2) {
				n = n - (a - v1);
				b = Math.max(y, b - n);

				o.println(b * v1);
			} else {
				n = n - (b - v2);
				a = Math.max(x, a - n);

				o.println(a * v2);
			}
		}

		o.flush();
		o.close();
	}
}