import java.util.*;
import java.io.*;

public class Pair_Programming {

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
			int k = t.nextInt();
			int n = t.nextInt();
			int m = t.nextInt();
			int[] a = new int[n];
			int[] b = new int[m];
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int j = 0; j < m; ++j)
				b[j] = t.nextInt();

			int i = 0, j = 0;

			while (i < n && j < m) {
				if (a[i] == 0) {
					list.add(a[i]);

					++i;
					++k;
				} else if (a[i] <= k) {
					list.add(a[i]);

					++i;
				} else if (b[j] == 0) {
					list.add(b[j]);

					++j;
					++k;
				} else if (b[j] <= k) {
					list.add(b[j]);

					++j;
				} else
					break;
			}

			while (i < n) {
				if (a[i] == 0) {
					list.add(a[i]);

					++i;
					++k;
				} else if (a[i] <= k) {
					list.add(a[i]);

					++i;
				} else
					break;
			}

			while (j < m) {
				if (b[j] == 0) {
					list.add(b[j]);

					++j;
					++k;
				} else if (b[j] <= k) {
					list.add(b[j]);

					++j;
				} else
					break;
			}

			if (i != n || j != m)
				o.println("-1");
			else {
				for (int val : list)
					o.print(val + " ");

				o.println();
			}

		}

		o.flush();
		o.close();
	}
}
