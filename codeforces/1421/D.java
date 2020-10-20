import java.util.*;
import java.io.*;

public class Hexagons {

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
			long x = t.nextLong();
			long y = t.nextLong();
			long[] a = new long[6];

			for (int i = 0; i < 6; ++i)
				a[i] = t.nextLong();

			long c1 = Math.min(a[0], a[5] + a[1]);
			long c2 = Math.min(a[1], a[0] + a[2]);
			long c3 = Math.min(a[2], a[1] + a[3]);
			long c4 = Math.min(a[3], a[2] + a[4]);
			long c5 = Math.min(a[4], a[3] + a[5]);
			long c6 = Math.min(a[5], a[4] + a[0]);
			long ans = 0;

			if (x == 0 || y == 0) {
				if (x == 0) {
					if (y > 0) {
						ans = y * c2;
					} else {
						ans = (-y) * c5;
					}
				} else {
					if (x > 0) {
						ans = x * c6;
					} else {
						ans = (-x) * c3;
					}
				}
			} else if (x > 0 && y > 0) {
				long min = Math.min(x, y);
				ans = min * c1;
				x -= min;
				y -= min;

				if (x > 0)
					ans += x * c6;
				else
					ans += y * c2;
			} else if (x < 0 && y < 0) {
				long max = Math.max(x, y);
				ans = (-max) * c4;
				x -= max;
				y -= max;

				if (x != 0)
					ans += (-x) * c3;
				else
					ans += (-y) * c5;
			} else if (x > 0 && y < 0) {
				ans = x * c6 - y * c5;
			} else {
				ans = -x * c3 + y * c2;
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}