import java.util.*;
import java.io.*;

public class _13th_Labours_Of_Heracles {

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
			int[] a = new int[n];
			long[] weight = new long[n];
			long ans = 0;

			for (int i = 0; i < n; ++i) {
				weight[i] = t.nextLong();
				ans += weight[i];
			}

			for (int i = 0; i < n - 1; ++i) {
				int x = t.nextInt() - 1;
				int y = t.nextInt() - 1;
				++a[x];
				++a[y];
			}

			List<long[]> list = new ArrayList<>();

			for (int i = 0; i < n; ++i) {
				if (a[i] > 1) {
					list.add(new long[] { weight[i], a[i] - 1 });
				}
			}

			Collections.sort(list, (c, b) -> cmp(c, b));

			o.print(ans + " ");

			for (int i = 0; i < list.size(); ++i) {
				long cnt = list.get(i)[1];

				while (cnt-- > 0l) {
					ans += list.get(i)[0];

					o.print(ans + " ");
				}
			}

			o.println();

		}

		o.flush();
		o.close();
	}

	private static int cmp(long[] a, long[] b) {
		return a[0] - b[0] < 0l ? 1 : a[0] - b[0] > 0l ? -1 : 0;
	}
}