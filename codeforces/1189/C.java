import java.util.*;
import java.io.*;

public class Candies {
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
		int[] dp = new int[n + 1];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; ++i) {
			int x = t.nextInt();
			dp[i + 1] = dp[i] + x;
		}

		int q = t.nextInt();

		while (q-- > 0) {
			int x = t.nextInt();
			int y = t.nextInt();

			sb.append((dp[y] - dp[x - 1]) / 10);
			sb.append("\n");
		}

		o.println(sb);
		o.flush();
		o.close();
	}
}
