import java.util.*;
import java.io.*;

public class The_Great_Hero {

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
			long A = t.nextLong();
			long B = t.nextLong();
			int n = t.nextInt();
			long[][] a = new long[n][2];

			for (int i = 0; i < n; ++i)
				a[i][0] = t.nextLong();

			for (int i = 0; i < n; ++i)
				a[i][1] = t.nextLong();

			int i = 0;
			long max = 0;

			while (i < n) {
				long times = (a[i][1] + A - 1) / A;
				B -= times * a[i][0];
				max = Math.max(max, a[i][0]);
				++i;
			}

			o.println(B + max > 0 ? "YES" : "NO");
		}

		o.flush();
		o.close();
	}
}