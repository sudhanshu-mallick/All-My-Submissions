
import java.util.*;
import java.io.*;

public class Pipes {

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
			String s1 = t.next();
			String s2 = t.next();
			int cur = 0;
			boolean f = true;

			for (int i = 0; i < n; ++i) {
				int n1 = (int) (s1.charAt(i) - '0');
				int n2 = (int) (s2.charAt(i) - '0');

				if (cur == 0 && (n1 == 1 || n1 == 2)) {

				} else if (cur == 1 && (n2 == 1 || n2 == 2)) {

				} else {
					cur = 1 - cur;

					if (cur == 1 && (n2 == 1 || n2 == 2)) {
						f = false;
						break;
					} else if (cur == 0 && (n1 == 1 || n1 == 2)) {
						f = false;
						break;
					}
				}
			}

			if (f && cur == 1)
				o.println("YES");
			else
				o.println("NO");
		}

		o.flush();
		o.close();
	}
}