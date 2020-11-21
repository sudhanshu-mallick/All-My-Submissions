import java.util.*;
import java.io.*;

public class You_Are_Given_Two_Binary_Strings {

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
			String x = t.next();
			String y = t.next();

			int idx = y.length() - 1;

			while (y.charAt(idx) == '0') {
				--idx;
			}

			int ans = 0;
			idx = x.length() - (y.length() - idx);

			while (x.charAt(idx) == '0') {
				--idx;
				++ans;
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}