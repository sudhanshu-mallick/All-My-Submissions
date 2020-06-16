
import java.util.*;
import java.io.*;

public class Diverse_Matrix {

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

		if (m + n != 2) {

			if (n == 1) {
				for (int i = 0; i < m; ++i)
					o.print((i + 2) + " ");
			} else
				for (int i = 0; i < m; ++i) {
					for (int j = 0; j < n; ++j)
						o.print((i + 1) * (m + j + 1) + " ");

					o.print("\n");
				}
		} else
			o.print("0");

		o.flush();
		o.close();
	}
}