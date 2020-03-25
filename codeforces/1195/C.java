import java.io.*;
import java.util.*;

public class Basketball_Exercise {

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
		long[][] h = new long[2][n];
		long[][] a = new long[2][n];

		for (int i = 0; i < 2; i++)
			for (int j = 0; j < n; j++)
				h[i][j] = t.nextLong();

		for (int i = 0; i < Math.min(2, n); i++) {
			if (i == 0) {
				a[0][i] = h[0][i];
				a[1][i] = h[1][i];
			} else {
				a[0][i] = a[1][i - 1] + h[0][i];
				a[1][i] = a[0][i - 1] + h[1][i];
			}
		}

		for (int i = 2; i < n; i++) {
			a[0][i] = Math.max(a[1][i - 1], a[1][i - 2]) + h[0][i];
			a[1][i] = Math.max(a[0][i - 1], a[0][i - 2]) + h[1][i];
		}

		o.println(Math.max(a[0][n - 1], a[1][n - 1]));

		o.flush();
		o.close();
	}
}