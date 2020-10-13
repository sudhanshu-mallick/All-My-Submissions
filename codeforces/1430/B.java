import java.util.*;
import java.io.*;

public class Barrels {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int k = t.nextInt();
			long[] a = new long[n];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextLong();

			shuffle(a);
			Arrays.sort(a);

			int i = n - 2;

			while (k-- > 0) {
				a[n - 1] += a[i--];
			}

			o.println(a[n - 1]);
		}

		o.flush();
		o.close();
	}

	public static void shuffle(long[] x) {
		Random r = new Random();

		for (int i = 0; i <= x.length - 2; i++) {
			int j = i + r.nextInt(x.length - i);

			swap(x, i, j);
		}
	}

	public static void swap(long[] x, int i, int j) {
		long t = x[i];
		x[i] = x[j];
		x[j] = t;
	}
}