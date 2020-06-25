import java.util.*;
import java.io.*;

public class Badge {

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
		int[] a = new int[n + 1];

		for (int i = 1; i <= n; i++)
			a[i] = t.nextInt();

		for (int i = 1; i <= n; i++) {
			int cur = i;
			int vis[] = new int[n + 1];

			while (true) {
				vis[cur]++;

				if (vis[cur] > 1)
					break;

				cur = a[cur];
			}

			o.print(cur + " ");
		}

		o.flush();
		o.close();
	}
}