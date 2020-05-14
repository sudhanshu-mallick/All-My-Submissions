import java.util.*;
import java.io.*;

public class Palindrome_Transformation {

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
		int k = t.nextInt();
		StringBuilder s = new StringBuilder(" ");
		String sb = t.next();
		int moves = 0;

		s.append(sb);

		if (k > (n + 1) / 2) {
			k = n - k + 1;
		}

		int l = k, r = k;

		for (int i = k; i >= 1; --i) {
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(n - i + 1);

			if (ch1 != ch2)
				l = i;
		}

		for (int i = k; i <= n / 2; ++i) {
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(n - i + 1);

			if (ch1 != ch2)
				r = i;
		}

		if (k - l <= r - k) {
			moves = k - l + r - l;

			for (int i = k; i >= l; --i) {
				char ch1 = s.charAt(i);
				char ch2 = s.charAt(n - i + 1);

				if (ch1 != ch2) {
					int v = (int) (ch1 - ch2 + 26) % 26;
					int u = (int) (ch2 - ch1 + 26) % 26;
					moves += Math.min(u, v);
				}
			}

			for (int i = k + 1; i <= r; ++i) {
				char ch1 = s.charAt(i);
				char ch2 = s.charAt(n - i + 1);

				if (ch1 != ch2) {
					int v = (int) (ch1 - ch2 + 26) % 26;
					int u = (int) (ch2 - ch1 + 26) % 26;
					moves += Math.min(u, v);
				}
			}
		} else {
			moves = r - k + r - l;

			for (int i = k + 1; i <= r; ++i) {
				char ch1 = s.charAt(i);
				char ch2 = s.charAt(n - i + 1);

				if (ch1 != ch2) {
					int v = (int) (ch1 - ch2 + 26) % 26;
					int u = (int) (ch2 - ch1 + 26) % 26;
					moves += Math.min(u, v);
				}
			}

			for (int i = k; i >= l; --i) {
				char ch1 = s.charAt(i);
				char ch2 = s.charAt(n - i + 1);

				if (ch1 != ch2) {
					int v = (int) (ch1 - ch2 + 26) % 26;
					int u = (int) (ch2 - ch1 + 26) % 26;
					moves += Math.min(u, v);
				}
			}
		}

		o.println(moves);

		o.flush();
		o.close();
	}
}