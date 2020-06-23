import java.util.*;
import java.io.*;

public class RationalLee {

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
			long[] a = new long[n];
			int k = t.nextInt();
			int[] b = new int[k];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextLong();

			for (int i = 0; i < k; ++i)
				b[i] = t.nextInt();

			Arrays.sort(a);
			Arrays.sort(b);

			long ans = 0;
			int i = n - 1, j = 0;

			for (int p = 0; p < k; ++p) {
				if (b[p] != 1)
					break;

				ans += a[i] + a[i];
				--i;
			}

			for (int p = k - 1; p >= 0; --p) {

				if (b[p] == 1)
					break;

				ans += a[i] + a[j];
				i--;
				j = j + (b[p] - 1);

			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}