import java.util.*;
import java.io.*;

public class AND_Sequence {

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

		Arrays.sort(a);
	}

	public static void swap(int[] a, int i, int j) {
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			long facN2 = 1;
			long mod = 1000000007;
			long[] a = new long[n];
			long ans = 0;
			int cur = 34;
			long now = 1;

			for (long i = 2; i <= n - 2; ++i) {
				facN2 = (facN2 * i) % mod;
			}

			for (int i = 0; i < n; ++i)
				a[i] = t.nextLong();

			long and = a[0];

			for (long v : a)
				and = (and & v);

			long count = 0;

			for (long v : a)
				if (v == and)
					++count;

			ans = (count * (count - 1)) % mod;
			ans = (ans * facN2) % mod;

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}