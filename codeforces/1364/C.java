import java.util.*;
import java.io.*;

public class Ehab_And_Prefix_Mex {

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
		boolean vis[] = new boolean[n + 1];
		int[] a = new int[n];
		int[] ans = new int[n];

		Arrays.fill(ans, -1);

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();
			vis[a[i]] = true;
		}

		for (int i = 1; i < n; ++i) {
			if (a[i] != a[i - 1])
				ans[i] = a[i - 1];
		}

		int cur = 0;

		for (int i = 0; i < n; ++i) {
			if (ans[i] == -1) {
				while (vis[cur]) {
					cur++;
				}

				ans[i] = cur;
				vis[cur] = true;
			}
		}

		for (int i : ans)
			o.print(i + " ");

		o.flush();
		o.close();
	}
}