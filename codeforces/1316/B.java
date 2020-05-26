import java.util.*;
import java.io.*;

public class String_Modification {

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
			String comp = s;
			int min = 1;

			for (int k = 2; k <= n; ++k) {

				String st = s.substring(0, k - 1);
				String en = s.substring(k - 1);

				if (((n - k) & 1) == 0) {
					StringBuilder sb = new StringBuilder(st);
					sb.reverse();
					st = sb.toString();
				}

				String cur = en.concat(st);

				if (cur.compareTo(comp) < 0) {
					comp = cur;
					min = k;
				}

			}

			o.println(comp);
			o.println(min);
		}

		o.flush();
		o.close();
	}
}