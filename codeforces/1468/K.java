import java.util.*;
import java.io.*;

public class The_Robot {

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
			String s = t.next();
			int n = s.length();
			int i = 0;
			long x = 0, y = 0;
			boolean flag = false;

			while (i < n) {
				char ch = s.charAt(i);

				if (ch == 'L')
					--x;
				else if (ch == 'R')
					++x;
				else if (ch == 'D')
					--y;
				else
					++y;

				if (x == 0 && y == 0) {
					++i;
					continue;
				}

				int j = 0;
				long curx = 0, cury = 0;

				while (j < n) {
					ch = s.charAt(j);

					if (ch == 'L') {
						if (curx - 1 != x || cury != y)
							--curx;
					} else if (ch == 'R') {
						if (curx + 1 != x || cury != y)
							++curx;
					} else if (ch == 'D') {
						if (curx != x || cury - 1 != y)
							--cury;
					} else {
						if (curx != x || cury + 1 != y)
							++cury;
					}

					++j;
				}

				if (curx == 0 && cury == 0) {
					flag = true;
					break;
				}

				++i;
			}

			if (flag)
				o.println(x + " " + y);
			else
				o.println("0 0");

		}

		o.flush();
		o.close();
	}
}