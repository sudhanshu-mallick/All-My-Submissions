import java.util.*;
import java.io.*;

public class Number_Of_Apartments {

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
		int[][] dp = new int[3][1001];

		for (int i = 5; i <= 1000; ++i) {
			if (i % 3 == 0)
				dp[0][i] = i / 3;
			else if (i % 5 == 0)
				dp[1][i] = i / 5;
			else if (i % 7 == 0) {
				dp[2][i] = i / 7;
			} else {
				int cur = i;
				int five = 0;

				while (cur % 3 != 0) {
					cur -= 5;
					five++;
				}

				dp[0][i] = cur / 3;
				dp[1][i] = five;
			}
		}

		while (test-- > 0) {
			int n = t.nextInt();

			if (n == 1 || n == 2 || n == 4)
				o.println("-1");
			else if (n == 3)
				o.println("1 0 0");
			else
				o.println(dp[0][n] + " " + dp[1][n] + " " + dp[2][n]);
		}

		o.flush();
		o.close();
	}
}