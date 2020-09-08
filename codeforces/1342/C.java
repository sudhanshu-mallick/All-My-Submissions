
import java.util.*;
import java.io.*;

public class Yet_Another_Counting_Problem {

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
			int q = t.nextInt();
			long gcd = gcd(a < b ? a : b, a > b ? a : b);
			long lcm = (a * b) / gcd;
			long m = a > b ? a : b;

			while (q-- > 0) {
				long l = t.nextLong();
				long r = t.nextLong() + 1;
				long v1 = (l / lcm) * lcm;
				long v2 = (r / lcm) * lcm;
				long left = (l / lcm) * m + (l > (v1 + m) ? (v1 + m) : l) - v1;
				long right = (r / lcm) * m + (r > (v2 + m) ? (v2 + m) : r) - v2;

				o.print(r - l - right + left + " ");
			}

			o.println();
		}

		o.flush();
		o.close();
	}

	private static long gcd(long a, long b) {
		if (a == 0)
			return b;

		return gcd(b % a, a);
	}
}