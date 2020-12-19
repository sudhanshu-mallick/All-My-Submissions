import java.util.*;
import java.io.*;

public class Row_GCD {

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
		int m = t.nextInt();
		int n = t.nextInt();
		long[] a = new long[m];
		long ans = 0;

		for (int i = 0; i < m; ++i)
			a[i] = t.nextLong();

		for (int i = 1; i < m; ++i) {
			ans = gcd(ans, Math.max(a[i], a[0]) - Math.min(a[i], a[0]));
		}

		for (int i = 0; i < n; ++i) {
			o.print(gcd(ans, a[0] + t.nextLong()) + " ");
		}
		o.flush();
		o.close();
	}

	public static long gcd(long a, long b) {
		if (a == 0)
			return b;

		return gcd(b % a, a);
	}
}