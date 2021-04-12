import java.util.*;
import java.io.*;

public class Education {

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
			long c = t.nextLong();
			long min = Long.MAX_VALUE;
			long[] a = new long[n];
			long[] b = new long[n];
			long carry = 0, accumulate = 0;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextLong();

			for (int i = 0; i < n - 1; ++i)
				b[i] = t.nextLong();

			for (int i = 0; i < n; ++i) {
				min = Math.min(min, carry + Math.max(0, c - accumulate + a[i] - 1) / a[i]);
				long days = Math.max(0, b[i] - accumulate + a[i] - 1) / a[i];
				carry += days + 1;
				accumulate += a[i] * days - b[i];
			}

			o.println(min);
		}

		o.flush();
		o.close();
	}
}