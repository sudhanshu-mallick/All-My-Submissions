import java.util.*;
import java.io.*;

public class Appllo_Versus_Pan {

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
			long[] bits = new long[60];
			long[] a = new long[n];
			long ans = 0;
			long mod = 1000000007;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong();
				long temp = a[i];
				int cur = 0;

				while (temp > 0) {
					if ((temp & 1) == 1)
						++bits[cur];

					++cur;
					temp >>= 1;
				}
			}

			for (int i = 0; i < n; ++i) {
				long cur = 1;
				long now = a[i];
				long and = 0;
				long or = 0;

				for (int j = 0; j < 60; ++j) {
					if ((now & 1) == 1) {
						and = (and + bits[j] * cur) % mod;
						or = (or + n * cur) % mod;
					} else {
						or = (or + bits[j] * cur) % mod;
					}

					now >>= 1;
					cur = (cur << 1) % mod;
				}

				ans = (ans + and * or) % mod;
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}