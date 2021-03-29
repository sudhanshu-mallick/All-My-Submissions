import java.util.*;
import java.io.*;

public class Box_Fitting {

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
			int w = t.nextInt();
			int[][] count = new int[21][2];
			int cur = 1;
			int ans = 0;

			for (int i = 0; i < 21; ++i) {
				count[i][0] = cur;
				cur <<= 1;
			}

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt();
				int idx = -1;

				while (x > 0) {
					++idx;
					x >>= 1;
				}

				++count[idx][1];
			}

			int rem = w;

			while (n > 0) {
				int i = 20;
				++ans;

				while (i >= 0) {
					if (count[i][1] > 0 && count[i][0] <= rem) {
						while (count[i][1] > 0 && count[i][0] <= rem) {
							rem -= count[i][0];
							--n;
							--count[i][1];
						}
					}

					--i;
				}

				rem = w;

			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}