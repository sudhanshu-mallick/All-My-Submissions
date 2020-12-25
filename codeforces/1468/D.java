import java.util.*;
import java.io.*;

public class Firecrackers {

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

	public static void shuffle(long[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}
	}

	public static void swap(long[] a, int i, int j) {
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			long n = t.nextLong();
			int m = t.nextInt();
			long x = t.nextLong();
			long y = t.nextLong();
			long[] a = new long[m];

			for (int i = 0; i < m; ++i)
				a[i] = t.nextLong();

			shuffle(a);
			Arrays.sort(a);

			long bombs = (x < y) ? y - x - 1 : x - y - 1;
			long curTime = 1;
			int i = m - 1;
			long ans = 0;
			long maxTime = (x < y) ? y - 1 : n - y;

			while (i >= 0) {
				if (a[i] + curTime <= maxTime) {
					++ans;
					++curTime;
				}

				--i;
			}

			o.println(Math.min(bombs, ans));
		}

		o.flush();
		o.close();
	}
}
