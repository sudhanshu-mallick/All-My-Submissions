import java.util.*;
import java.io.*;

public class Maximum_Sum_Of_Even_Position {

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
			long sum = 0;
			long x = 0, y = 0;
			long max = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong();

				if ((i & 1) == 0)
					sum += a[i];
			}

			for (int i = 0; i < n - 1; i += 2) {
				x += a[i + 1] - a[i];
				y += (i + 2) < n ? a[i + 1] - a[i + 2] : 0;

				if (x < 0)
					x = 0;

				if (y < 0)
					y = 0;

				max = Math.max(max, Math.max(x, y));
			}

			o.println(sum + max);
		}

		o.flush();
		o.close();
	}
}