import java.util.*;
import java.io.*;

public class Array_Sum {

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
			int k = t.nextInt();
			int f = t.nextInt();
			int cnt = 1;
			int cur = f;

			while (n-- > 1) {
				f = t.nextInt();

				if (cur != f) {
					cur = f;
					++cnt;
				}
			}

			if (k > 1) {
				if (k >= cnt)
					o.println("1");
				else {
					int ans = 1;
					cnt -= k;
					ans += (cnt + (k - 2)) / (k - 1);

					o.println(ans);
				}
			} else {
				if (cnt > 1)
					o.println("-1");
				else
					o.println("1");
			}

		}

		o.flush();
		o.close();
	}
}