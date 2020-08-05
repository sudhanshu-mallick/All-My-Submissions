import java.util.*;
import java.io.*;

public class Gifts_Fixing {
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
			long[] b = new long[n];
			long mina = Integer.MAX_VALUE;
			long minb = Integer.MAX_VALUE;
			long ans = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong();
				mina = a[i] < mina ? a[i] : mina;
			}

			for (int i = 0; i < n; ++i) {
				b[i] = t.nextLong();
				minb = b[i] < minb ? b[i] : minb;
			}

			for (int i = 0; i < n; ++i) {
				long v1 = a[i] - mina;
				long v2 = b[i] - minb;
				ans += Math.max(v1, v2);
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}
