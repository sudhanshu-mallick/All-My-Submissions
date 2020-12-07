import java.util.*;
import java.io.*;

public class Errich_Tac_Toe {

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
			int n = t.nextInt();
			char[][] ch = new char[n][n];

			for (int i = 0; i < n; ++i) {
				String s = t.next();

				for (int j = 0; j < n; ++j)
					ch[i][j] = s.charAt(j);
			}

			int zero = 0, one = 0, two = 0;

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (ch[i][j] == 'X') {
						if ((i + j) % 3 == 0)
							++zero;
						else if ((i + j) % 3 == 1)
							++one;
						else
							++two;
					}
				}
			}

			if (zero <= one && zero <= two) {
				for (int i = 0; i < n; ++i)
					for (int j = 0; j < n; ++j)
						if (ch[i][j] == 'X' && (i + j) % 3 == 0)
							ch[i][j] = 'O';
			} else if (one <= zero && one <= two) {
				for (int i = 0; i < n; ++i)
					for (int j = 0; j < n; ++j)
						if (ch[i][j] == 'X' && (i + j) % 3 == 1)
							ch[i][j] = 'O';
			} else {
				for (int i = 0; i < n; ++i)
					for (int j = 0; j < n; ++j)
						if (ch[i][j] == 'X' && (i + j) % 3 == 2)
							ch[i][j] = 'O';
			}

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j)
					o.print(ch[i][j]);

				o.println();
			}
		}

		o.flush();
		o.close();
	}
}