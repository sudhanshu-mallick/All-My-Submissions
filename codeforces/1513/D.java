import java.util.*;
import java.io.*;

public class GCD_And_MST {

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
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			long p = t.nextLong();
			long cost = 0;
			long[] a = new long[n];
			Pair[] pair = new Pair[n];
			boolean[] vis = new boolean[n];

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong();
				pair[i] = new Pair(a[i], i);
			}

//			System.out.println(a[0]);

			Arrays.sort(pair, (x, y) -> Long.compare(x.val, y.val));

//			for (int i = 0; i < n; ++i)
//				System.out.print(pair[i].val + " - " + pair[i].idx + ", ");
//
//			System.out.println();

			for (int i = 0; i < n; ++i) {
				if (pair[i].val >= p)
					break;

				int ii = pair[i].idx;

				while (ii > 0) {
					if (vis[ii - 1])
						break;

					if (a[ii - 1] % pair[i].val == 0) {
						cost += pair[i].val;
						vis[ii - 1] = true;
					} else
						break;

					--ii;
				}

				ii = pair[i].idx;

				while (ii < n - 1) {
					if (vis[ii])
						break;

					if (a[ii + 1] % pair[i].val == 0) {
						cost += pair[i].val;
						vis[ii] = true;
					} else
						break;

					++ii;
				}
			}

			for (int i = 0; i < n - 1; ++i)
				if (!vis[i])
					cost += p;

			o.println(cost);
		}

		o.flush();
		o.close();
	}
}

class Pair {
	long val;
	int idx;

	Pair(long val, int idx) {
		this.val = val;
		this.idx = idx;
	}
}