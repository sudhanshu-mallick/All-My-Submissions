import java.util.*;
import java.io.*;

public class Party {

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
		int[][] a = new int[2][n];
		int max = 0;

		for (int i = 0; i < n; i++) {
			a[0][i] = t.nextInt();

			if (a[0][i] == -1)
				a[1][i] = 1;
			else
				a[1][i] = -1;
		}

		for (int i = 0; i < n; i++) {
			int sum = 1, cur = i;

			while (a[0][cur] != -1) {
				sum++;
				cur = a[0][cur];
				cur--;
			}

			a[1][i] = sum;
		}

		for (int i = 0; i < n; i++)
			max = Math.max(max, a[1][i]);

		o.println(max);

		o.flush();
		o.close();
	}
}