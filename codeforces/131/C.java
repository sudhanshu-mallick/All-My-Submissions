import java.util.*;
import java.io.*;

public class The_World_Is_A_Theatre {

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
		long m = t.nextLong();
		long k = t.nextLong();
		long i = Math.max(4, k - m);
		long ans = 0;

		while (i <= n && k - i >= 1) {
			ans += nCr(n, i) * nCr(m, k - i);
			++i;
		}

		o.println(ans);

		o.flush();
		o.close();
	}

	static long nCr(long n, long k) {
		long res = 1;

		if (k > n - k)
			k = n - k;
		for (long i = 0; i < k; ++i) {
			res *= (n - i);
			res /= (i + 1);
		}

		return res;
	}
}