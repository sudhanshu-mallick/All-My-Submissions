import java.util.*;
import java.io.*;

public class New_Year_And_North_Year {

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
		boolean ans = true;
		long cur = 0;

		while (test-- > 0) {
			int m = t.nextInt();
			String s = t.next();

			if (s.equals("North")) {
				if (cur - m < 0)
					ans = false;

				cur -= m;
			} else if (s.equals("South")) {
				if (m + cur > 20000)
					ans = false;

				cur += m;
			} else if ((s.equals("East") || s.equals("West")) && (cur == 0 || cur == 20000)) {
				ans = false;
			}
		}

		if (ans && cur == 0)
			o.println("YES");
		else
			o.println("NO");

		o.flush();
		o.close();
	}
}