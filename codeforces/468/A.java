import java.util.*;
import java.io.*;

public class Game_24 {

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

		if (n <= 3) {
			o.println("NO");
		} else {
			o.println("YES");

			if (n == 4) {
				o.println("4 * 3 = 12");
				o.println("12 * 2 = 24");
				o.println("24 * 1 = 24");
			} else if (n == 5) {
				o.println("4 + 5 = 9");
				o.println("9 + 3 = 12");
				o.println("12 * 2 = 24");
				o.println("24 * 1 = 24");
			} else {
				o.println("5 + 1 = 6");
				o.println("6 - 6 = 0");

				int cur = 7;
				while (cur <= n) {
					o.println(cur + " * 0 = 0");
					cur++;
				}

				o.println("4 * 3 = 12");
				o.println("12 * 2 = 24");
				o.println("24 + 0 = 24");
			}
		}

		o.flush();
		o.close();
	}
}
