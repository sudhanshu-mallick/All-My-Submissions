import java.util.*;
import java.io.*;

public class Balls_Of_Steel {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			long k = t.nextLong();
			long[][] cord = new long[n][2];
			boolean res = false;

			for (int i = 0; i < n; ++i) {
				cord[i][0] = t.nextLong();
				cord[i][1] = t.nextLong();
			}

			for (int i = 0; i < n; ++i) {
				int cnt = 0;

				for (int j = 0; j < n; ++j) {
					if (i != j) {
						long md = Math.abs(cord[i][0] - cord[j][0]) + Math.abs(cord[i][1] - cord[j][1]);

						if (md <= k) {
							cnt++;
						} else {
							break;
						}
					}
				}

				if (cnt == n - 1) {
					res = true;
					break;
				}
			}

			o.println(res ? "1" : "-1");
		}

		o.flush();
		o.close();
	}
}