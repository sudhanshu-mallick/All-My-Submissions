import java.util.*;
import java.io.*;

public class String_LCM {

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

		while (test-- > 0) {
			String x = t.next();
			int m = x.length();
			String y = t.next();
			int n = y.length();
			int lcm = (m * n) / gcd(m, n);
			StringBuilder X = new StringBuilder(x);
			StringBuilder Y = new StringBuilder(y);

			while (X.length() < lcm)
				X.append(x);

			while (Y.length() < lcm)
				Y.append(y);

			if (X.toString().equals(Y.toString()))
				sb.append(X);
			else
				sb.append("-1");

			sb.append("\n");
		}

		o.println(sb);
		o.flush();
		o.close();
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;

		return gcd(b, a % b);
	}
}