import java.util.*;
import java.io.*;

public class A_New_Technique {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int m = t.nextInt();
			int n = t.nextInt();
			int[][] rows = new int[m][n];
			Map<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < m; ++i)
				for (int j = 0; j < n; ++j) {
					rows[i][j] = t.nextInt();

					map.put(rows[i][j], i);
				}

			int[][] cols = new int[n][m];

			for (int i = 0; i < n; ++i)
				for (int j = 0; j < m; ++j) {
					cols[i][j] = t.nextInt();

				}

			for (int i = 0; i < m; ++i) {
				int idx = map.get(cols[0][i]);

				for (int j = 0; j < n; ++j) {
					o.print(rows[idx][j] + " ");
				}

				o.println();
			}
		}

		o.flush();
		o.close();
	}
}