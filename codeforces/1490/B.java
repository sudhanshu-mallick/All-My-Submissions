import java.util.*;
import java.io.*;

public class Balanced_Reminders {

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

		Arrays.sort(a);
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
			int c0 = 0, c1 = 0, c2 = 0;

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt();

				if (x % 3 == 0)
					++c0;
				else if (x % 3 == 1)
					++c1;
				else
					++c2;
			}

			n /= 3;
			int ans = 0;

			if (c2 < n) {
				int dif = n - c2;

				if (dif <= c1 - n) {
					c1 -= dif;
					ans += dif;
				} else {
					if (c1 >= n) {
						c2 += c1 - n;
						ans += c1 - n;
						c1 = n;
					}

					ans += 2 * (n - c2);
					c0 -= (n - c2);
					c2 = n;
				}
			}

			int a = c0, b = c1, c = c2;
			c0 = c;
			c1 = a;
			c2 = b;

			if (c2 < n) {
				int dif = n - c2;

				if (dif <= c1 - n) {
					c1 -= dif;
					ans += dif;
				} else {
					if (c1 >= n) {
						c2 += c1 - n;
						ans += c1 - n;
						c1 = n;
					}

					ans += 2 * (n - c2);
					c0 -= (n - c2);
					c2 = n;
				}
			}

			a = c1;
			b = c2;
			c = c0;
			c0 = b;
			c1 = c;
			c2 = a;

			if (c2 < n) {
				int dif = n - c2;

				if (dif <= c1 - n) {
					c1 -= dif;
					ans += dif;
				} else {
					if (c1 >= n) {
						c2 += c1 - n;
						ans += c1 - n;
						c1 = n;
					}

					ans += 2 * (n - c2);
					c0 -= (n - c2);
					c2 = n;
				}
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}