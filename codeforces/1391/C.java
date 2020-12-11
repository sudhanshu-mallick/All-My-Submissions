import java.util.*;
import java.io.*;

public class Cyclic_Permutation {

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
		long n = t.nextLong();
		long mod = 1000000007;
		long cur = 1;
		long pow = 1;

		while (n-- > 0) {
			cur = (cur * (n + 1)) % mod;

			if (n >= 1)
				pow = (pow * 2) % mod;
		}

		cur = (cur - pow + mod) % mod;

		o.println(cur);
		o.flush();
		o.close();
	}
}