import java.util.*;
import java.io.*;

public class The_Number_Of_Products {

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
		long[] dp = new long[n + 1];
		long tc = (long) n * (long) (n + 1) / 2, ev = 0, od = 0, pos = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		for (int i = 0; i < n; ++i) {
			if (a[i] < 0)
				dp[i + 1] = dp[i] + 1;
			else
				dp[i + 1] = dp[i];
		}

		for (int i = 0; i < n; ++i) {
			if ((dp[i] & 1) == 0)
				ev++;
			else
				od++;

			if ((dp[i + 1] & 1) == 0)
				pos += ev;
			else
				pos += od;
		}

		o.println((tc - pos) + " " + pos);

		o.flush();
		o.close();
	}
}