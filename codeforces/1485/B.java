import java.util.*;
import java.io.*;

public class Replace_And_Keep_Sorted {

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
		int test = 1;

		while (test-- > 0) {
			int n = t.nextInt();
			int q = t.nextInt();
			long k = t.nextLong();
			long[] a = new long[n];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextLong();

			while (q-- > 0) {
				int l = t.nextInt() - 1;
				int r = t.nextInt() - 1;

				o.println(a[l] - 1 + k - a[r] + 2 * (a[r] - a[l] + 1 - (r - l + 1)));
			}

		}

		o.flush();
		o.close();
	}
}