import java.util.*;
import java.io.*;

public class Matrix_Game {

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
			int[][] a = new int[m][n];
			Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();

			for (int i = 0; i < m; ++i)
				for (int j = 0; j < n; ++j) {
					a[i][j] = t.nextInt();

					if (a[i][j] == 1) {
						s1.add(i);
						s2.add(j);
					}
				}

			int count = 0;

			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (a[i][j] == 0 && !s1.contains(i) && !s2.contains(j)) {
						count++;
						s1.add(i);
						s2.add(j);
					}
				}
			}

			if ((count & 1) == 0)
				o.println("Vivek");
			else
				o.println("Ashish");

		}

		o.flush();
		o.close();
	}
}
