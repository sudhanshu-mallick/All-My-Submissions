import java.util.*;
import java.io.*;

public class Make_It_Good {

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
			int idx = n - 1;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = n - 1; i > 0; --i) {
				if (a[i] > a[i - 1]) {
					break;
				}

				idx = i - 1;
			}

			int i = idx;

			for (i = idx; i > 0; --i) {
				if (a[i] < a[i - 1])
					break;
			}

			o.println(i);
		}

		o.flush();
		o.close();
	}
}