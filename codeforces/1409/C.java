import java.util.*;
import java.io.*;

public class Yet_Another_Array_Restoration {

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
			long x = t.nextLong();
			long y = t.nextLong();
			long[] a = new long[n];
			long d = 1;

			for (int i = 1; i <= 50; ++i) {
				if ((y - x) % i == 0 && (y - x) / i <= n - 1) {
					d = i;
					break;
				}
			}

			a[0] = x;
			a[1] = y;
			long cur = x + d;
			int i = 2;

			while (i < n) {
				if (cur != y) {
					a[i++] = cur;
					cur += d;
				} else
					break;
			}

			cur = x - d;

			while (i < n) {
				if (cur > 0) {
					a[i++] = cur;
					cur -= d;
				} else
					break;
			}

			cur = y + d;

			while (i < n) {
				a[i++] = cur;
				cur += d;
			}

			for (i = 0; i < n; ++i)
				o.print(a[i] + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}