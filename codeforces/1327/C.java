import java.util.*;
import java.io.*;

public class Game_With_Chips {

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
		int q = t.nextInt();

		while (q-- > 0) {
			int a = t.nextInt();
			int b = t.nextInt();
		}

		o.println(n + m + m * n - 3);

		for (int i = 0; i < n - 1; i++)
			o.print('U');

		for (int j = 0; j < m - 1; j++)
			o.print('L');

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)
				for (int j = 0; j < m - 1; j++)
					o.print('R');
			else
				for (int j = 0; j < m - 1; j++)
					o.print('L');

			if (i < n - 1)
				o.print('D');
		}

		o.flush();
		o.close();
	}
}