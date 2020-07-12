import java.util.*;
import java.io.*;

public class Omkar_And_Circle {

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
		int n = t.nextInt();
		long[] a = new long[n];
		long[] pre = new long[n];
		long[] suf = new long[n];

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		if (n > 1) {
			pre[0] = a[0];
			pre[1] = a[1];
			suf[n - 1] = a[n - 1];
			suf[n - 2] = a[n - 2];

			int i = 2, j = n - 3;

			while (i < n && j >= 0) {
				pre[i] = a[i] + pre[i - 2];
				suf[j] = a[j] + suf[j + 2];
				++i;
				--j;
			}

			long max = suf[0];

			for (i = 1; i < n; ++i) {
				max = Math.max(max, suf[i] + pre[i - 1]);
			}

			o.println(max);

		} else {
			o.println(a[0]);
		}

		o.flush();
		o.close();
	}
}