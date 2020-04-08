import java.util.*;
import java.io.*;

public class Skyscrapers {

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
		long[] a = new long[n];

		for (int i = 0; i < n; i++)
			a[i] = t.nextLong();

		long[] ans = new long[n];
		long[] res = new long[n];
		long max = 0;

		for (int i = 0; i < n; i++) {
			ans[i] = a[i];
			long sum = 0;

			for (int j = i - 1; j >= 0; j--)
				ans[j] = Math.min(a[j], ans[j + 1]);

			for (int j = i + 1; j < n; j++)
				ans[j] = Math.min(a[j], ans[j - 1]);

			for (int j = 0; j < n; j++)
				sum += ans[j];

			if (sum > max) {
				max = sum;

				for (int j = 0; j < n; j++)
					res[j] = ans[j];
			}
		}

		for (int j = 0; j < n; j++)
			o.print(res[j] + " ");

		o.flush();
		o.close();
	}
}
