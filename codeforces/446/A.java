import java.util.*;
import java.io.*;

public class DZY_Loves_Sequences {

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
		int[] a = new int[n + 2];
		int[] l = new int[n + 2];
		int[] r = new int[n + 2];

		for (int i = 1; i <= n; ++i)
			a[i] = t.nextInt();

		for (int i = 1; i <= n; ++i) {
			if (a[i - 1] < a[i])
				l[i] = l[i - 1] + 1;
			else
				l[i] = 1;
		}

		for (int i = n; i >= 1; --i) {
			if (a[i] < a[i + 1])
				r[i] = r[i + 1] + 1;
			else
				r[i] = 1;
		}

		int ans = 0;

		for (int i = 1; i <= n; ++i) {
			ans = Math.max(ans, l[i - 1] + 1);
			ans = Math.max(ans, r[i + 1] + 1);

			if (a[i - 1] + 1 < a[i + 1])
				ans = Math.max(ans, l[i - 1] + r[i + 1] + 1);
		}

		o.println(ans);

		o.flush();
		o.close();
	}
}