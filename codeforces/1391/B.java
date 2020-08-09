import java.util.*;
import java.io.*;

public class Fix_You {

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
			char ch[][] = new char[m][n];
			int count = 0;

			for (int i = 0; i < m; ++i) {
				String s = t.next();

				for (int j = 0; j < n; ++j)
					ch[i][j] = s.charAt(j);
			}

			for (int i = 0; i < n - 1; ++i)
				if (ch[m - 1][i] != 'R')
					count++;

			for (int i = 0; i < m - 1; ++i)
				if (ch[i][n - 1] != 'D')
					count++;

			o.println(count);

		}

		o.flush();
		o.close();
	}
}