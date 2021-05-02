import java.util.*;
import java.io.*;

public class Phoenix_And_Socks {

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
			int l = t.nextInt();
			int r = t.nextInt();
			int[] left = new int[n];
			int[] right = new int[n];
			int cost = 0;
			int x = l, y = r;

			while (l-- > 0)
				++left[t.nextInt() - 1];

			while (r-- > 0)
				++right[t.nextInt() - 1];

			for (int i = 0; i < n; ++i) {
				int min = Math.min(left[i], right[i]);
				left[i] -= min;
				right[i] -= min;
				x -= min;
				y -= min;
			}

			if (x > y) {
				int idx = 0;

				while (idx < n && x > y) {
					while (left[idx] > 1 && x > y) {
						++cost;
						left[idx] -= 2;
						x -= 2;
					}

					++idx;
				}
			} else {
				int idx = 0;

				while (idx < n && y > x) {
					while (right[idx] > 1 && y > x) {
						++cost;
						right[idx] -= 2;
						y -= 2;
					}

					++idx;
				}
			}

			int max = Math.max(x, y);
			cost += max;

			o.println(cost);
		}

		o.flush();
		o.close();
	}
}