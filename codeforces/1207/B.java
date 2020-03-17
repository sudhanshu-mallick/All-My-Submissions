import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Square_Filling {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int m = t.nextInt();
		int n = t.nextInt();
		int[][] a = new int[m][n];
		int[][] b = new int[m][n];
		StringBuilder ans = new StringBuilder();
		int count = 0;

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = t.nextInt();

		for (int i = 0; i < m - 1; i++)
			for (int j = 0; j < n - 1; j++) {
				if (a[i][j] * a[i][j + 1] * a[i + 1][j] * a[i + 1][j + 1] > 0) {
					count++;
					b[i][j] = b[i + 1][j] = b[i][j + 1] = b[i + 1][j + 1] = 1;
					ans.append((i + 1) + " " + (j + 1) + "\n");
				}
			}

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (a[i][j] != b[i][j]) {
					o.println(-1);
					o.flush();
					o.close();
				}
			}

		o.println(count);
		o.println(ans);
		o.flush();
		o.close();
	}

}