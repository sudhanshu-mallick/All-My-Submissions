import java.util.*;
import java.io.*;

public class Even_Odd_Game {

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
			int n = t.nextInt();
			long[] a = new long[n];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextLong();

			shuffle(a);
			Arrays.sort(a);

			int i = n - 1;
			long ans = 0;

			while (i >= 0) {
				long x = a[i];

				if (((n - i) & 1) == 1) {
					if ((x & 1) == 0)
						ans += x;
				} else {
					if ((x & 1) == 1)
						ans -= x;
				}

				--i;
			}

			o.println(ans > 0 ? "Alice" : ans < 0 ? "Bob" : "Tie");
		}

		o.flush();
		o.close();
	}
}