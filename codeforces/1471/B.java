import java.util.*;
import java.io.*;

public class Strange_List {

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
			long x = t.nextLong();
			long sum = 0;
			int idx = -1;
			long min = Integer.MAX_VALUE;
			long[] a = new long[n];

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong();
				long temp = a[i];
				long pow = 0;

				while ((temp % x) == 0) {
					++pow;
					temp /= x;
				}

				if (min > pow) {
					min = pow;
					idx = i;
				}

				sum += a[i];
			}

			sum = sum * (min + 1);

			for (int i = 0; i < idx; ++i)
				sum += a[i];

			o.println(sum);
		}

		o.flush();
		o.close();
	}
}