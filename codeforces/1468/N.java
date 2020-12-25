import java.util.*;
import java.io.*;

public class Waste_Sorting {

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
			int c1 = t.nextInt();
			int c2 = t.nextInt();
			int c3 = t.nextInt();
			int a1 = t.nextInt();
			int a2 = t.nextInt();
			int a3 = t.nextInt();
			int a4 = t.nextInt();
			int a5 = t.nextInt();
			String ans = "YES";

			if (c1 >= a1) {
				c1 -= a1;
			} else {
				ans = "NO";
			}

			if (c2 >= a2) {
				c2 -= a2;
			} else {
				ans = "NO";
			}

			if (c3 >= a3) {
				c3 -= a3;
			} else {
				ans = "NO";
			}

			if (c1 + c3 >= a4) {
				if (a4 > c1) {
					a4 -= c1;
					c1 = 0;
					c3 -= a4;
				} else {
					c1 -= a4;
				}
			} else {
				ans = "NO";
			}

			if (c2 + c3 >= a5) {
				if (a5 > c2) {
					a5 -= c2;
					c2 = 0;
					c3 -= a5;
				} else {
					c2 -= a5;
				}
			} else {
				ans = "NO";
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}