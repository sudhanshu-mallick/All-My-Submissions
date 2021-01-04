import java.util.*;
import java.io.*;

public class Correct_Placement {

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
			Pair[] p = new Pair[n];

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt();
				int y = t.nextInt();
				p[i] = new Pair(i + 1, Math.min(x, y), Math.max(x, y));
			}

			Arrays.sort(p, (x, y) -> x.height != y.height ? x.height - y.height : x.width - y.width);

			int[] ans = new int[n];
			int i = 0;
			int miny = Integer.MAX_VALUE;
			int minyIdx = -1;
			int curX = p[0].height;
			int j = 0;

			while (i < n) {
				while (j < n) {
					if (p[j].height < p[i].height) {
						if (p[j].width < miny) {
							miny = p[j].width;
							minyIdx = p[j].idx;
						}
					} else
						break;

					++j;
				}

				if (p[i].height == curX) {
					ans[p[i].idx - 1] = -1;
				} else {
					if (miny < p[i].width) {
						ans[p[i].idx - 1] = minyIdx;
					} else {
						ans[p[i].idx - 1] = -1;
					}
				}

				if (i < n - 1 && p[i].height != p[i + 1].height) {
					curX = p[i].height;
				}

				++i;
			}

			for (i = 0; i < n; ++i)
				o.print(ans[i] + " ");

			o.println();
		}

		o.flush();
		o.close();
	}

	static class Pair {
		int idx;
		int height;
		int width;

		Pair(int idx, int height, int width) {
			this.idx = idx;
			this.height = height;
			this.width = width;
		}
	}
}