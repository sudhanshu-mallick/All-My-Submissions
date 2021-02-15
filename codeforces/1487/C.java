import java.util.*;
import java.io.*;

public class Minimum_Ties {

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
			int[][] mat = new int[n][n];

			for (int i = 0; i < n; ++i) {
				int j = 0;
				int half = (n - 1) >> 1;

				while (j < half) {
					int y = (j + i + 1) % n;
					mat[i][y] = 1;
					++j;
				}

				if ((n & 1) == 0) {
					++j;
				}

				while (j < n) {
					int y = (j + i + 1) % n;
					mat[i][y] = -1;
					++j;
				}

			}

			for (int i = 0; i < n; ++i)
				for (int j = i + 1; j < n; ++j)
					o.print(mat[i][j] + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}