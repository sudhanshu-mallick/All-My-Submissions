import java.util.*;
import java.io.*;

public class Circle_Of_Monstors {

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
			long[] hel = new long[n], def = new long[n];
			long[] dp = new long[n];
			long min = Long.MAX_VALUE, sum = 0;

			for (int i = 0; i < n; ++i) {
				hel[i] = t.nextLong();
				def[i] = t.nextLong();
			}

			for (int i = 0; i < n; ++i) {
				int idx = (i == 0 ? n - 1 : i - 1);
				dp[i] = (hel[i] - def[idx] <= 0) ? 0 : hel[i] - def[idx];
				sum += dp[i];
			}

//			for (int i = 0; i < n; ++i)
//				System.out.print(dp[i] + " ");

			for (int i = 0; i < n; ++i) {
				min = Math.min(min, sum - dp[i] + hel[i]);
			}

			o.println(min);

		}
		o.flush();
		o.close();
	}
}
