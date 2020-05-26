import java.util.*;
import java.io.*;

public class Remove_One_Element {

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
		int[] a = new int[n];
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		dp1[0] = 1;
		dp2[n - 1] = 1;
		int max = 1;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		for (int i = 1; i < n; ++i) {
			if (a[i] > a[i - 1])
				dp1[i] = dp1[i - 1] + 1;
			else
				dp1[i] = 1;

			max = Math.max(dp1[i], max);
		}

		for (int i = n - 2; i >= 0; --i) {
			if (a[i] < a[i + 1])
				dp2[i] = dp2[i + 1] + 1;
			else
				dp2[i] = 1;
		}

		for (int i = 0; i < n - 2; ++i)
			if (a[i] < a[i + 2])
				max = Math.max(max, dp1[i] + dp2[i + 2]);

		o.println(max);

		o.flush();
		o.close();
	}
}
