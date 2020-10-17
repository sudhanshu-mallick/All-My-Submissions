import java.util.*;
import java.io.*;

public class Labs {

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
		int low = 1, high = n * n;
		int[][] a = new int[n][n];
		int k = (n + 1) >> 1;
		int i = 0;
		int j = 0;

		while (j < k) {
			a[i][j] = low;
			low += n;
			++j;
		}

		j = n - 1;

		while (j >= k) {
			a[i][j] = high;
			high -= n;
			--j;
		}

		i = 1;

		while (i < n) {
			j = 0;

			while (j < n) {
				if (j < k) {
					a[i][j] = a[i - 1][j] + 1;
				} else {
					a[i][j] = a[i - 1][j] - 1;
				}

				++j;
			}

			++i;
		}

		for (i = 0; i < n; ++i) {
			for (j = 0; j < n; ++j) {
				o.print(a[i][j] + " ");
			}

			o.println();
		}

		o.flush();
		o.close();
	}
}