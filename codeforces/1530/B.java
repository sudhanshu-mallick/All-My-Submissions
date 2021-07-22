import java.util.*;
import java.io.*;

public class Putting_Plates {

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
			int m = t.nextInt();
			int n = t.nextInt();
			int[][] mat = new int[m][n];
			mat[0][0] = 1;
			int start = 0;

			for (int j = 2; j < n; j += 2)
				mat[0][j] = 1;

			for (int i = 2; i < m; i += 2)
				mat[i][n - 1] = 1;

			for (int j = n - 3; j >= 0; j -= 2)
				mat[m - 1][j] = 1;

			for (int i = m - 3; i > 1; i -= 2)
				mat[i][0] = 1;

			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j)
					o.print(mat[i][j]);

				o.println();
			}

		}

		o.flush();
		o.close();
	}
}