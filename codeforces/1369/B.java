import java.util.*;
import java.io.*;

public class AccurateLee {

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
			String s = t.next();
			int first = -1;

			for (int i = 0; i < n; ++i) {
				if (s.charAt(i) == '1')
					break;

				first = i;
			}

			int cur = 0;

			while (cur <= first) {
				o.print("0");
				cur++;
			}

			int last = 0;

			for (int i = n - 1; i >= 0; --i) {
				if (s.charAt(i) == '0') {
					last = i;
					break;
				}
			}

			cur = last;

			if (cur == first)
				cur++;

			while (cur < n)
				o.print(s.charAt(cur++));

			o.println();
		}

		o.flush();
		o.close();
	}
}
