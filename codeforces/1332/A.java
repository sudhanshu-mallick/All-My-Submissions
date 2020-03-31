import java.util.*;
import java.io.*;

public class Exercising_Walk {

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
			long a = t.nextLong();
			long b = t.nextLong();
			long c = t.nextLong();
			long d = t.nextLong();
			long x = t.nextLong(), y = t.nextLong(), x1 = t.nextLong(), y1 = t.nextLong(), x2 = t.nextLong(),
					y2 = t.nextLong();
			long ad = x - x1;
			long bd = x2 - x;
			long cd = y - y1;
			long dd = y2 - y;
			boolean flag = true;

			if (ad == 0 && bd == 0 && (b > 0 || a > 0)) {
				o.println("No");
				continue;
			} else if (cd == 0 && dd == 0 && (c > 0 || d > 0)) {
				o.println("No");
				continue;
			} else {
				if (b - a > 0 && bd < b - a) {
					o.println("No");
					continue;
				}
				if (a - b > 0 && ad < a - b) {
					o.println("No");
					continue;
				}
				if (c - d > 0 && cd < c - d) {
					o.println("No");
					continue;
				}
				if (d - c > 0 && dd < d - c) {
					o.println("No");
					continue;
				}

				o.println("Yes");
			}
		}
		o.flush();
		o.close();
	}
}