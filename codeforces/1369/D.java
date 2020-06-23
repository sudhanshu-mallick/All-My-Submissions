
import java.util.*;
import java.io.*;

public class TediousLee {

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
		long mod = (long) 1e9 + 7;
		long[] a = new long[2000001];
		a[0] = a[1] = a[2] = 0l;

		for (int i = 3; i < a.length; ++i) {
			a[i] = (a[i - 1] + a[i - 2] * 2 + ((i % 3 == 0) ? 1 : 0)) % mod;
		}

		while (test-- > 0) {
			int n = t.nextInt();

			o.println((a[n] * 4) % mod);
		}

		o.flush();
		o.close();
	}
}