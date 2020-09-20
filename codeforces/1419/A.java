import java.util.*;
import java.io.*;

public class Digit_Game {

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
			int rodd = 0, reven = 0, bodd = 0, beven = 0;
			boolean res;
			String s = t.next();

			for (int i = 0; i < n; ++i) {
				if ((i & 1) == 0) {
					if (((s.charAt(i) - '0') & 1) == 0)
						reven++;
					else
						rodd++;
				} else {
					if (((s.charAt(i) - '0') & 1) == 0)
						beven++;
					else
						bodd++;
				}
			}

			if ((n & 1) == 0) {
				if (beven > 0)
					res = false;
				else
					res = true;
			} else {
				if (rodd > 0)
					res = true;
				else
					res = false;
			}

			if (res)
				o.println("1");
			else
				o.println("2");
		}

		o.flush();
		o.close();
	}
}