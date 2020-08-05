import java.util.*;
import java.io.*;

public class Boats_Competiton {
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
			int[] a = new int[n + 1];
			int max = 0;

			for (int i = 0; i < n; ++i)
				a[t.nextInt()]++;

			for (int i = 2; i <= 2 * n; ++i) {
				int cnt = 0;
				int x = 1;
				int y = n;

				while (x < y) {
					if (x + y == i) {
						cnt += Math.min(a[y], a[x]);
						++x;
						--y;
					} else if (x + y < i) {
						++x;
					} else {
						--y;
					}
				}

				if ((i & 1) == 0)
					cnt += a[i >> 1] >> 1;

				max = cnt > max ? cnt : max;
			}

			o.println(max);
		}

		o.flush();
		o.close();
	}
}
