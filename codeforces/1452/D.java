import java.util.*;
import java.io.*;

public class Radio_Towers {

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

	public static long mod = 998244353;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		long n = t.nextLong();
		long f1 = 0, f2 = 1;
		long pow = 1;

		while (n-- > 0) {
			long temp = (f1 + f2) % mod;
			f1 = f2;
			f2 = temp;
			pow = (pow << 1) % mod;
		}
		
		o.println((f1 * pow(pow, mod - 2)) % mod);

		o.flush();
		o.close();
	}

	public static long pow(long a, long b) {
		long res = 1;

		while (b > 0) {
			if ((b & 1) == 1)
				res = (res * a) % mod;

			b = b >> 1;
			a = (a * a) % mod;
		}

		return res;
	}
}