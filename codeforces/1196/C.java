import java.util.*;
import java.io.*;

public class Robot_Breakout {

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
			int xmin = -100000, xmax = 100000, ymin = -100000, ymax = 100000;

			while (n-- > 0) {
				int sign;
				int x = t.nextInt();
				int y = t.nextInt();
				sign = t.nextInt();

				if (sign == 0)
					xmin = Math.max(xmin, x);

				sign = t.nextInt();

				if (sign == 0)
					ymax = Math.min(ymax, y);

				sign = t.nextInt();

				if (sign == 0)
					xmax = Math.min(xmax, x);

				sign = t.nextInt();

				if (sign == 0)
					ymin = Math.max(ymin, y);

			}

			if (xmax - xmin < 0 || ymax - ymin < 0)
				o.println("0");
			else
				o.println("1 " + xmax + " " + ymax);
		}

		o.flush();
		o.close();
	}
}