import java.util.*;
import java.io.*;

public class Sweet_Eating {

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
		Long[] a = new Long[n];
		long[] dp = new long[n];
		long sum = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();
		
		Arrays.sort(a);

		for (int i = 0; i < n; ++i) {
			sum += a[i];
			dp[i] = sum;

			if (i >= m)
				dp[i] += dp[i - m];
		}

		for (int i = 0; i < n; ++i)
			o.print(dp[i] + " ");

		o.flush();
		o.close();
	}
}