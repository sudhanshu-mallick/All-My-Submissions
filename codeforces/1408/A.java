import java.util.*;
import java.io.*;

public class Circle_Coloring {

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
			int[] b = new int[n];
			int[] c = new int[n];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = 0; i < n; ++i)
				b[i] = t.nextInt();

			for (int i = 0; i < n; ++i)
				c[i] = t.nextInt();

			int[] ans = new int[n];
			ans[0] = a[0];

			for (int i = 1; i < n - 1; ++i) {
				if (a[i] != ans[i - 1])
					ans[i] = a[i];
				else if (b[i] != ans[i - 1])
					ans[i] = b[i];
				else
					ans[i] = c[i];
			}

			if (ans[0] != a[n - 1] && ans[n - 2] != a[n - 1])
				ans[n - 1] = a[n - 1];

			else if (ans[0] != b[n - 1] && ans[n - 2] != b[n - 1])
				ans[n - 1] = b[n - 1];
			else
				ans[n - 1] = c[n - 1];

			for (int el : ans)
				o.print(el + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}