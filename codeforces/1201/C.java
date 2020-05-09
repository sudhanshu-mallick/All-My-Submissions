import java.util.*;
import java.io.*;

public class Maximum_Median {

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
		Long[] a = new Long[n];
		long k = t.nextLong();
		long dp[] = new long[n];

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		Arrays.sort(a);

		for (int i = n / 2 + 1; i < n; ++i) {
			dp[i] = dp[i - 1] + (i - n / 2) * (a[i] - a[i - 1]);
		}

		int idx = n - 1;

		for (int j = n / 2; j < n; ++j) {
			if (k < dp[j]) {
				idx = j - 1;
				break;
			}
		}

		k -= dp[idx];
		long ans = a[idx] + ((idx + 1 - n / 2 != 0) ? k / (idx + 1 - n / 2) : 0);

		o.println(ans);

		o.flush();
		o.close();
	}
}