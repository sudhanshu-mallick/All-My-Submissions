import java.util.*;
import java.io.*;

public class New_Year_And_Domino {

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
		int m = t.nextInt();
		int n = t.nextInt();
		char[][] ch = new char[m][n];
		int[][] hor = new int[m + 1][n + 1];
		int[][] ver = new int[m + 1][n + 1];

		for (int i = 0; i < m; ++i) {
			String s = t.next();

			for (int j = 0; j < n; ++j)
				ch[i][j] = s.charAt(j);
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				hor[i + 1][j + 1] = hor[i][j + 1] + hor[i + 1][j] - hor[i][j];
				ver[i + 1][j + 1] = ver[i][j + 1] + ver[i + 1][j] - ver[i][j];

				if (ch[i][j] == '#')
					continue;

				if (j > 0 && ch[i][j - 1] == '.')
					++hor[i + 1][j + 1];

				if (i > 0 && ch[i - 1][j] == '.')
					++ver[i + 1][j + 1];
			}
		}

		int q = t.nextInt();

		while (q-- > 0) {
			int x1 = t.nextInt();
			int y1 = t.nextInt();
			int x2 = t.nextInt();
			int y2 = t.nextInt();
			int ans = 0;
			ans += hor[x2][y2] - hor[x1 - 1][y2] - hor[x2][y1] + hor[x1 - 1][y1];
			ans += ver[x2][y2] - ver[x1][y2] - ver[x2][y1 - 1] + ver[x1][y1 - 1];

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}