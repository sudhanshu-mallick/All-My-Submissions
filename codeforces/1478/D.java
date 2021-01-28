import java.util.*;
import java.io.*;

public class Nezzar_And_Board {

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
			long[] a = new long[n];
			long k = t.nextLong();
			long min = Long.MAX_VALUE;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong();
				min = a[i] > min ? min : a[i];
			}

			long gcd = 0;
			k -= min;

			for (int i = 0; i < n; ++i) {
				gcd = gcd(gcd, a[i] - min);
			}

			if (k % gcd == 0)
				o.println("YES");
			else
				o.println("NO");
		}

		o.flush();
		o.close();
	}

	private static long gcd(long a, long b) {
		if (a == 0)
			return b;

		return gcd(b % a, a);
	}

}