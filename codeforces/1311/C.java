import java.util.*;
import java.io.*;

public class Perform_The_Combo {

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
			int m = t.nextInt();
			int[][] a = new int[n + 1][26];
			boolean vis[] = new boolean[26];
			String s = t.next();

			for (int i = 1; i <= n; ++i) {
				int idx = s.charAt(i - 1) - 'a';

				for (int j = 0; j < 26; ++j) {
					if (j == idx)
						a[i][j] = a[i - 1][j] + 1;
					else if (vis[j])
						a[i][j] = a[i - 1][j];

					vis[idx] = true;
				}
			}

			int ans[] = new int[26];

			while (m-- > 0) {
				int i = t.nextInt();

				for (int j = 0; j < 26; ++j)
					ans[j] += a[i][j];
			}

			for (int i = 0; i < n; ++i) {
				int idx = s.charAt(i) - 'a';

				ans[idx]++;
			}

			for (int j = 0; j < 26; ++j)
				o.print(ans[j] + " ");

			o.println();

		}

		o.flush();
		o.close();
	}
}