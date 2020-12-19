import java.util.*;
import java.io.*;

public class Pairs {

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
			int[] a = new int[n];
			Set<Integer> set = new HashSet<>();
			int[] b = new int[n];

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();

				set.add(a[i]);
			}

			int cur = 1;
			int idx = 0;

			while (idx < n) {
				if (set.contains(cur)) {
				} else {
					b[idx++] = cur;
				}

				++cur;
			}

			int less = n, more = 0;
			int x = 0, y = n;

			while (x <= y) {
				int mid = x + ((y - x) >> 1);
				boolean res = true;
				int i = 0, j = n - mid;

				while (i < mid) {
					if (a[i] > b[j]) {
						res = false;
						break;
					}

					++i;
					++j;
				}

				if (res) {
					x = mid + 1;
				} else {
					y = mid - 1;
					less = y;
				}
			}

			x = 0;
			y = n;

			while (x <= y) {
				int mid = x + ((y - x) >> 1);
				boolean res = true;
				int i = n - mid, j = 0;

				while (j < mid) {
					if (a[i] < b[j]) {
						res = false;
						break;
					}

					++i;
					++j;
				}

				if (res) {
					x = mid + 1;
				} else {
					y = mid - 1;
					more = n - y;
				}
			}

			if (less >= more)
				o.println(less - more + 1);
			else
				o.println("0");
		}

		o.flush();
		o.close();
	}
}
//ok