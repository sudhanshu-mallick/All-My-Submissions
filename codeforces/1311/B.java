import java.util.*;
import java.io.*;

public class WeirdSort {

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
		StringBuilder sb = new StringBuilder();

		while (test-- > 0) {
			int n = t.nextInt();
			int m = t.nextInt();
			int[] a = new int[n];
			boolean[] vis = new boolean[n];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = 0; i < m; ++i)
				vis[t.nextInt() - 1] = true;

			for (int i = 0; i < n; ++i) {
				int si = i;

				while (si >= 0) {
					if (vis[si]) {
						if (a[si] > a[si + 1]) {
							a[si] = a[si] + a[si + 1] - (a[si + 1] = a[si]);
						}
					} else {
						break;
					}

					si--;
				}
			}

			boolean flag = true;

			for (int i = 0; i < n - 1; ++i) {
				if (a[i] > a[i + 1]) {
					flag = false;
					break;
				}
			}

			if (flag)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}

		o.println(sb);
		o.flush();
		o.close();
	}
}