import java.util.*;
import java.io.*;

public class Unusual_Matrix {

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
			int[][] a = new int[n][n];
			int[][] b = new int[n][n];

			for (int i = 0; i < n; ++i) {
				String s = t.next();

				for (int j = 0; j < n; ++j)
					a[i][j] = s.charAt(j) - '0';
			}

			for (int i = 0; i < n; ++i) {
				String s = t.next();

				for (int j = 0; j < n; ++j)
					b[i][j] = s.charAt(j) - '0';
			}

			a = variPuttar(a, n);
			a = hariPuttar(a, n);
			b = variPuttar(b, n);
			b = hariPuttar(b, n);

			String ans = "YES";

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (a[i][j] != b[i][j]) {
						ans = "NO";
						break;
					}
				}

				if (ans.equals("NO"))
					break;
			}

			o.println(ans);

		}

		o.flush();
		o.close();
	}

	private static int[][] variPuttar(int[][] a, int n) {
		for (int j = 0; j < n; ++j)
			if (a[0][j] == 1)
				for (int i = 0; i < n; ++i)
					a[i][j] = a[i][j] ^ 1;

		return a;
	}

	private static int[][] hariPuttar(int[][] a, int n) {
		for (int i = 0; i < n; ++i)
			if (a[i][0] == 1)
				for (int j = 0; j < n; ++j)
					a[i][j] = a[i][j] ^ 1;

		return a;
	}

}