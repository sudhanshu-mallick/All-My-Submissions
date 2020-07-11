import java.util.*;
import java.io.*;

public class Omkar_And_Last_Class_Of_Math {

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
			long prime = n;

			if ((n & 1) == 0)
				prime = 2;

			if (prime == n)
				for (long i = 3; i * i <= n; i += 2) {
					if (n % i == 0) {
						prime = i;
						break;
					}
				}

			long v = n / prime;
			long x = 0, y = 0;

			if (v == 1) {
				x = 1;
				y = n - 1;
			} else {
				x = v;
				y = n - x;
			}

			o.println(x + " " + y);
		}

		o.flush();
		o.close();
	}
}