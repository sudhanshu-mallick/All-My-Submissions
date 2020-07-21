import java.util.*;
import java.io.*;

public class Sequential_Nim {

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
			int idx = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();
			}

			for (int i = 0; i < n; ++i) {
				if (a[i] == 1)
					idx = i + 1;
				else
					break;
			}

			if ((idx & 1) == 0) {
				n = n - idx;

				if (n > 0)
					o.println("First");
				else
					o.println("Second");
			} else {
				n = n - idx;

				if (n == 0)
					o.println("First");
				else
					o.println("Second");
			}
		}

		o.flush();
		o.close();
	}
}
