import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Elections {

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
		int n = t.nextInt();
		int m = t.nextInt();
		int[][] a = new int[m][n];
		int win[] = new int[n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = t.nextInt();

		for (int i = 0; i < m; i++) {
			int max = 0, midx = 0;

			for (int j = 0; j < n; j++) {
				if (a[i][j] > max) {
					max = a[i][j];
					midx = j;
				}
			}

			win[midx]++;
		}

		int max = 0, midx = 0;

		for (int i = 0; i < n; i++) {
			if (max < win[i]) {
				max = win[i];
				midx = i;
			}
		}

		o.println(midx + 1);
		o.flush();
		o.close();
	}

}