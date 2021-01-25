import java.util.*;
import java.io.*;

public class Advertising_Agency {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n];
			int k = t.nextInt();

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();
			}

			shuffle(a);
			Arrays.sort(a);

			int N = 0;
			int i = n - 1;
			int R = 0;

			while (i >= 0) {
				if (a[n - k] == a[i]) {
					++N;

					if (i >= n - k)
						++R;
				}
				
				--i;
			}

			long ans = nCr(N, R, 1000000007l);

			o.println(ans);
		}

		o.flush();
		o.close();
	}

	static long power(long x, long y, long p) {
		long res = 1;
		x = x % p;

		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % p;

			y = y >> 1;
			x = (x * x) % p;
		}

		return res;
	}

	static long modInverse(long n, long p) {
		return power(n, p - 2, p);
	}

	static long nCr(long n, long r, long p) {

		if (n < r)
			return 0;

		if (r == 0l)
			return 1;

		long[] fac = new long[(int) n + 1];
		fac[0] = 1;

		for (int i = 1; i <= n; i++)
			fac[i] = fac[i - 1] * i % p;

		return (fac[(int) n] * modInverse(fac[(int) r], p) % p * modInverse(fac[(int) (n - r)], p) % p) % p;
	}
}