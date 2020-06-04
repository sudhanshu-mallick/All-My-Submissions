import java.util.*;
import java.io.*;

public class Unususal_Competition {

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
		String s = t.next();
		int op = 0;

		for (int i = 0; i < n; ++i) {
			if (s.charAt(i) == ')')
				op++;
		}

		if (op * 2 == n) {
			int ans = 0, open = 0, close = 0, neg = 0, i = 0, cur = 0, prev = 0;

			while (i < n) {
				char ch = s.charAt(i);

				if (ch == ')') {
					close++;
					cur--;
				} else {
					cur++;
					open++;
				}

				if (cur < 0)
					neg = 1;

				if (open == close) {
					if (cur != 0 || neg == 1)
						ans += i - prev + 1;

					prev = i + 1;
					neg = 0;
				}
				
				++i;
			}

			o.println(ans);
		} else {
			o.println("-1");
		}

		o.flush();
		o.close();
	}
}