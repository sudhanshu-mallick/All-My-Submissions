import java.util.*;
import java.io.*;

public class K_Periodic_Garlands {

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
			int k = t.nextInt();
			int[] a = new int[n + 1];
			int[] b = new int[n];
			String s = t.next();
			int sum = 0;
			a[0] = s.charAt(0) - '0';

			for (int i = 1; i < n; ++i)
				a[i] = a[i - 1] + s.charAt(i) - '0';

			for (int i = n - 1; i >= 0; --i) {
				int ch = Integer.parseInt(s.charAt(i) + "");
				int v1, v2;

				if (i + k < n) {
					v1 = ((ch) ^ 1) + a[i + k - 1] - a[i] + b[i + k];
					v2 = (ch & 1) + a[n - 1] - a[i];
					b[i] = Math.min(v1, v2);
				} else {
					v1 = a[n - 1] - a[i];
					b[i] = v1;
				}
			}

//			for (int i = 0; i < n; ++i)
//				System.out.print(b[i] + " ");

			for (int i = 1; i < n; ++i) {
				b[i] += a[i - 1];
			}

			int min = Integer.MAX_VALUE;

			for (int i = 0; i < n; ++i)
				min = Math.min(b[i], min);
//
			o.println(min);
		}

		o.flush();
		o.close();
	}
}
