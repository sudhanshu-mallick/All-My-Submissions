import java.io.*;
import java.util.*;

public class Middle_Class {

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
			Integer[] a = new Integer[n];
			long x = t.nextLong();
			long[] dp = new long[n];
			int count = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();

			}

			Arrays.sort(a);

			dp[n - 1] = a[n - 1];

			if (dp[n - 1] < x)
				count = 0;
			else
				count = 1;

			for (int i = n - 2; i >= 0; --i) {
				dp[i] = dp[i + 1] + a[i];

				if (dp[i] / (n - i) >= x)
					count++;
				else
					break;
			}

			o.println(count);

		}

		o.flush();
		o.close();
	}
}