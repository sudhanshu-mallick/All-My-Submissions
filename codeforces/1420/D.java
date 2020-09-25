import java.util.*;
import java.io.*;

public class Rescue_Nibel {

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
		int n = t.nextInt();
		Pair[] p = new Pair[n << 1];
		int k = t.nextInt();
		long mod = 998244353;
		long[] fac = new long[300001];
		fac[0] = fac[1] = 1;
		int on = 0;
		long ans = 0;

		for (int i = 2; i < fac.length; ++i) {
			fac[i] = (fac[i - 1] * i) % mod;
		}

		for (int i = 0; i < n; ++i) {
			int start = t.nextInt();
			int end = t.nextInt();
			p[i << 1] = new Pair(start, 1);
			p[(i << 1) + 1] = new Pair(end, 0);
		}

		Arrays.sort(p, (Pair x, Pair y) -> cmp(x, y));

		for (int i = 0; i < (n << 1); ++i) {
			if (p[i].start == 1) {
				if (on >= k - 1) {
					ans = (ans + nCr(on, k - 1, mod, fac)) % mod;
				}

				++on;
			} else {
				--on;
			}
		}

		o.print(ans);
		o.flush();
		o.close();
	}

	private static int cmp(Pair x, Pair y) {
		if (x.val < y.val)
			return -1;
		else if (x.val > y.val)
			return 1;
		else if (x.start > y.start)
			return -1;
		else if (x.start == y.start)
			return 0;
		else
			return 1;
	}

	private static long nCr(int on, int k, long mod, long[] fac) {
		if (k == 0)
			return 1;

		return ((fac[on] * inv(fac[on - k], mod) % mod * inv(fac[k], mod))) % mod;
	}

	private static long inv(long on, long mod) {
		return fexpo(on, mod - 2, mod);
	}

	private static long fexpo(long on, long k1, long k2) {
		long ans = 1;

		while (k1 > 0) {
			if ((k1 & 1) == 1)
				ans = (ans * on) % k2;

			on = (on * on) % k2;
			k1 = k1 >> 1;
		}

		return ans;
	}

}

class Pair {
	int val;
	int start;

	Pair(int val, int start) {
		this.val = val;
		this.start = start;
	}
}