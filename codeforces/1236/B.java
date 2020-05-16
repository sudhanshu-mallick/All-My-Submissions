import java.io.*;
import java.util.*;

public class Alice_And_The_List_Of_Presents {
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

	static long mod = (long) (Math.pow(10, 9) + 7);

	public static void main(String[] args) {
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		long n = t.nextLong();
		long m = t.nextLong();
		long ans = powMod(2, m);

		ans--;
		if (ans < 0)
			ans += mod;

		o.println(powMod(ans, n));
		o.flush();
		o.close();
	}

	static long powMod(long a, long N) {
		if (N == 0)
			return 1;
		else if (N == 1)
			return a % mod;
		else {
			long R = powMod(a, N / 2) % mod;
			R *= R;
			R %= mod;
			if (N % 2 == 1) {
				R *= a;
				R %= mod;
			}
			return R % mod;
		}
	}
}