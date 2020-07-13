import java.util.*;
import java.io.*;

public class Berseck_And_Fireball {

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
		int m = t.nextInt();
		int n = t.nextInt();
		long x = t.nextLong();
		int k = t.nextInt();
		long y = t.nextLong();
		int[] a = new int[m];
		int[] b = new int[n];
		int[] idx = new int[n + 2];
		idx[0] = -1;
		idx[n + 1] = m;
		boolean flag = true;

		for (int i = 0; i < m; ++i)
			a[i] = t.nextInt();

		for (int i = 0; i < n; ++i)
			b[i] = t.nextInt();

		int I = 0, J = 0;

		while (I < m && J < n) {
			if (a[I] == b[J]) {
				idx[J + 1] = I;
				I++;
				J++;
			} else
				I++;
		}

		if (J != n)
			flag = false;

		if (flag) {
			flag = true;
			long cost = 0;

			if (x >= y * k) {
				int i = 1;

				while (i <= n + 1) {
					int cnt = idx[i] - idx[i - 1] - 1;
					int f = -1;

					for (int j = idx[i - 1] + 1; j < idx[i]; ++j) {
						if (i == 1) {
							if (a[j] > a[idx[i]]) {
								f = 0;
								break;
							}
						} else if (i < n + 1) {
							if (a[j] > Math.max(a[idx[i]], a[idx[i - 1]])) {
								f = 0;
								break;
							}
						} else {
							if (a[j] > a[idx[i - 1]]) {
								f = 0;
								break;
							}
						}
					}

					if (f == 0) {
						if (cnt >= k) {
							cost = cost + x + (cnt - k) * y;
						} else {
							flag = false;
							break;
						}
					} else {
						cost = cost + cnt * y;
					}

					++i;
				}

				if (flag)
					o.println(cost);
				else
					o.println("-1");
			} else {
				int i = 1;

				while (i <= n + 1) {
					int cnt = idx[i] - idx[i - 1] - 1;
					int f = -1;

					for (int j = idx[i - 1] + 1; j < idx[i]; ++j) {
						if (i == 1) {
							if (a[j] > a[idx[i]]) {
								f = 0;
								break;
							}
						} else if (i < n + 1) {
							if (a[j] > Math.max(a[idx[i]], a[idx[i - 1]])) {
								f = 0;
								break;
							}
						} else {
							if (a[j] > a[idx[i - 1]]) {
								f = 0;
								break;
							}
						}
					}

					if (f == 0) {
						if (cnt >= k) {
							long v = cnt / k;
							cost = cost + v * x + (cnt - k * v) * y;
						} else {
							flag = false;
							break;
						}
					} else {
						long v = cnt / k;
						cost = cost + v * x + (cnt - k * v) * y;
					}

					++i;
				}

				if (flag)
					o.println(cost);
				else
					o.println("-1");

			}
		} else
			o.println("-1");

		o.flush();
		o.close();
	}
}
