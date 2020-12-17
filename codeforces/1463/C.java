import java.util.*;
import java.io.*;

public class Busy_Robot {

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
			long[][] a = new long[n][2];

			for (int i = 0; i < n; ++i) {
				a[i][0] = t.nextLong();
				a[i][1] = t.nextLong();
			}

			int count = 0;
			long[] X = new long[n];
			int i = 1;
			long prev = 0;
			long next = a[0][1];
			long time = a[0][0];

			while (i < n) {
				long dtime = a[i][0] - a[i - 1][0];
				long now = Math.abs(prev - next) - dtime;

				if (now > 0) {
					X[i] = prev > next ? prev - dtime : prev + dtime;
				} else {
					X[i] = next;
					next = a[i][1];
				}

				prev = X[i];
				++i;
			}

			for (i = 0; i < n - 1; ++i) {
				long min = Math.min(X[i], X[i + 1]);
				long max = Math.max(X[i], X[i + 1]);

				if (a[i][1] >= min && a[i][1] <= max) {
					++count;
				}
			}

			long min = Math.min(prev, next);
			long max = Math.max(prev, next);

			if (a[n - 1][1] >= min && a[n - 1][1] <= max)
				++count;

			o.println(count);
		}

		o.flush();
		o.close();
	}
}