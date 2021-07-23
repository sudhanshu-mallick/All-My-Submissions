import java.util.*;
import java.io.*;

public class Wonderful_Coloring_2 {

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
			int k = t.nextInt();
			Pair pair[] = new Pair[n];
			int[] color = new int[k];
			int cur = k > 1 ? 1 : 0;

			for (int i = 0; i < n; ++i)
				pair[i] = new Pair(i, t.nextInt());

			Arrays.sort(pair, (x, y) -> x.val - y.val);

			pair[0].color = 0;
			color[0] = 1;

			for (int i = 1; i < n; ++i) {
				if (pair[i].val == pair[i - 1].val) {
					if (i >= k && pair[i].val == pair[i - k].val)
						pair[i].color = -1;
					else {
						pair[i].color = cur;
						++color[cur];
						cur = (cur + 1) % k;
					}
				} else {
					pair[i].color = cur;
					++color[cur];
					cur = (cur + 1) % k;
				}
			}

			int min = n;

			for (int v : color)
				min = Math.min(min, v);

			for (int i = 0; i < n; ++i) {
				int colorIndex = pair[i].color;

				if (colorIndex != -1 && color[colorIndex] > min) {
					--color[colorIndex];
					pair[i].color = -1;
				}
			}

			int[] ans = new int[n];

			for (int i = 0; i < n; ++i)
				ans[pair[i].idx] = pair[i].color + 1;

			for (int v : ans)
				o.print(v + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}

class Pair {
	int idx;
	int val;
	int color;

	Pair(int idx, int val) {
		this.idx = idx;
		this.val = val;
	}
}