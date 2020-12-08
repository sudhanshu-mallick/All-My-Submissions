import java.util.*;
import java.io.*;

public class Tiles {

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
		long pow = t.nextLong() + t.nextLong();
		long mod = 998244353;
		long ans = 1;
		long cur = 2;

		while (pow > 0) {
			if ((pow & 1) == 1) {
				ans = (ans * cur) % mod;
				--pow;
			} else {
				pow >>= 1;
				cur = (cur * cur) % mod;
			}
		}

		o.println(ans);
		o.flush();
		o.close();
	}
}