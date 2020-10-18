import java.util.*;
import java.io.*;

public class Putting_Bricks_In_The_Wall {

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
			int m = t.nextInt();
			int n = m;
			int[][] a = new int[m][n];

			for (int i = 0; i < m; ++i) {
				String s = t.next();

				for (int j = 0; j < n; ++j) {
					if (s.charAt(j) == '0')
						a[i][j] = 0;
					else if (s.charAt(j) == '1')
						a[i][j] = 1;
				}
			}

			int v1 = a[0][1];
			int v2 = a[1][0];
			int v3 = a[m - 1][n - 2];
			int v4 = a[m - 2][n - 1];

			if ((v1 + v2 == 2 && v3 + v4 == 0) || (v1 + v2 == 0 && v3 + v4 == 2))
				o.println("0");
			else if (v1 + v2 == v3 + v4 && (v1 + v2 == 0 || v1 + v2 == 2)) {
				o.println("2");
				o.println("1 2");
				o.println("2 1");
			} else if (v1 + v2 == v3 + v4) {
				o.println("2");

				if (v1 == 1)
					o.println("1 2");
				else
					o.println("2 1");

				if (v3 == 0)
					o.println(m + " " + (n - 1));
				else
					o.println((m - 1) + " " + n);
			} else {
				o.println("1");

				if (v1 == v2) {
					if (v3 == v1)
						o.println(m + " " + (n - 1));
					else
						o.println((m - 1) + " " + n);
				} else {
					if (v1 == v3)
						o.println("1 2");
					else
						o.println("2 1");
				}
			}
		}

		o.flush();
		o.close();
	}
}