import java.util.*;
import java.io.*;

public class Array_Cancellation {

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
			int[] a = new int[n];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			int neg = n - 1;
			int pos = n - 1;

			while (neg >= 0 && pos >= 0) {
				while (neg >= 0 && a[neg] >= 0)
					neg--;

				if (neg < 0)
					break;

				while (pos >= 0 && (a[pos] <= 0 || pos >= neg))
					pos--;

				if (pos < 0)
					break;

				int v1 = -a[neg];
				int v2 = a[pos];

				a[neg] = a[neg] + Math.min(v1, v2);
				a[pos] -= Math.min(v1, v2);
			}

			long s = 0;

			for (int i = 0; i < n; ++i)
				if (a[i] > 0)
					s += a[i];

			o.println(s);
		}

		o.flush();
		o.close();
	}
}