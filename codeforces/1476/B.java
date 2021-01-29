import java.util.*;
import java.io.*;

public class Inflation {

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
			long k = t.nextLong();
			long[] a = new long[n];
			long sum = 0;
			long req = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong();
				sum += a[i];
			}

			int i = n - 1;

			while (i >= 1) {
				sum -= a[i];
				if (100 * a[i] <= sum * k) {

				} else {
					long dif = 100 * a[i] - sum * k;
					long now = (dif + k - 1) / k;
					sum += now;
					req += now;
				}

				--i;
			}

			o.println(req);
		}

		o.flush();
		o.close();
	}
}