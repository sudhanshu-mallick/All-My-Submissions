import java.util.*;
import java.io.*;

public class Diverse_Garland {

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
		int n = t.nextInt(), count = 0;
		char[] c = new char[n];
		c = t.next().toCharArray();
		char ch[] = { 'R', 'B', 'G' };
		StringBuilder s = new StringBuilder();
		s.append(c[0]);

		for (int i = 1; i < n - 1; ++i) {
			if (c[i] == c[i - 1]) {
				if (ch[0] != c[i + 1] && ch[0] != c[i - 1]) {
					c[i] = ch[0];
				} else if (ch[1] != c[i + 1] && ch[1] != c[i - 1]) {
					c[i] = ch[1];
				} else
					c[i] = ch[2];

				++count;
			}
		}

		if (n > 1) {
			if (c[n - 1] == c[n - 2]) {
				if (ch[0] != c[n - 1]) {
					c[n - 1] = ch[0];
				} else if (ch[1] != c[n - 1]) {
					c[n - 1] = ch[1];
				} else
					c[n - 1] = ch[2];

				++count;
			}
		}

		o.println(count);
		o.println(new String(c));

		o.flush();
		o.close();
	}
}