import java.util.*;
import java.io.*;

public class Close_Tuples {

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
		fact[0] = invFact[0] = 1;

		for (int i = 1; i < 300500; i++) {
			fact[i] = (fact[i - 1] * i) % mod;
			invFact[i] = fastPow(fact[i], mod - 2);
		}

		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int m = t.nextInt();
			int k = t.nextInt();
			List<Integer> a = new ArrayList<>();
			Map<Integer, Integer> next = new HashMap<>();

			for (int i = 0; i < n; ++i)
				a.add(t.nextInt());

			Collections.sort(a);

			Map<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < n; ++i) {
				map.put(a.get(i), i);
			}

			int x = 0, y = 0;

			while (y < n) {
				if (a.get(y) - a.get(x) <= k) {
					++y;
				} else {
					next.put(a.get(x), a.get(y - 1));

					++x;
				}
			}

			while (x < n) {
				next.put(a.get(x), a.get(n - 1));

				++x;
			}

			long ans = 0;

			for (int i = 0; i < n; ++i) {
				int idx = map.get(next.get(a.get(i)));
				long ele = idx - i;

				if (ele >= m - 1)
					ans = (ans + nCr(ele, m - 1)) % mod;
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}

	public static long mod = 1000000007;
	public static long fact[] = new long[300500];
	public static long invFact[] = new long[300500];

	public static long fastPow(long a, long pow) {
		long res = 1;

		while (pow > 0) {
			if ((pow & 1) == 0) {
				a = (a * a) % mod;
				pow >>= 1;
			} else {
				res = (res * a) % mod;
				--pow;
			}
		}

		return res;
	}

	public static long nCr(long n, long r) {
		if (r > n) {
			return 0;
		}

		return fact[(int) n] * invFact[(int) r] % mod * invFact[(int) (n - r)] % mod;
	}
}