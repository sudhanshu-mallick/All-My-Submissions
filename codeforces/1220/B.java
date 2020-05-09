import java.util.*;
import java.io.*;

public class Multipliction_Table {
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
		long m[][] = new long[n][n];
		long[] a = new long[n];

		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j)
				m[i][j] = t.nextLong();

		a[0] = (long) (Math.sqrt(m[0][1] * m[0][2] / m[1][2]));

		for (int i = 1; i < n; ++i)
			a[i] = m[0][i] / a[0];

		for (int i = 0; i < n; ++i)
			o.print(a[i] + " ");

		o.flush();
		o.close();
	}
}