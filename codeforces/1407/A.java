
import java.util.*;
import java.io.*;

public class Ahahah {

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
			int one = 0;
			int zero = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();

				if (a[i] == 0)
					zero++;
				else
					one++;
			}

			if (zero >= one) {
				o.println(zero);

				while (zero-- > 0) {
					o.print("0 ");
				}
			} else {
				if ((one & 1) == 0) {
					o.println(one);

					while (one-- > 0)
						o.print("1 ");
				} else {
					o.println(one - 1);

					while (--one > 0)
						o.print("1 ");
				}
			}

			o.println();
		}

		o.flush();
		o.close();
	}
}