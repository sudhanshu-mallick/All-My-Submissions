import java.util.*;
import java.io.*;

public class Sign_Flipping {

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

			for (int i = 0; i < n; ++i)
				a[i] = t.nextLong();

			for (int i = 0; i < n; i += 2) {
				a[i] = -Math.abs(a[i]);

				if (i + 1 < n)
					a[i + 1] = Math.abs(a[i + 1]);
			}
			
			for (int i = 0; i < n; ++i)
				o.print(a[i] + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}