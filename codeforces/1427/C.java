import java.util.*;
import java.io.*;

public class The_Hard_Work_Of_Paparazzi {

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
		int r = t.nextInt();
		int n = t.nextInt();
		PAIR[] a = new PAIR[n + 1];
		a[0] = new PAIR(0, 1, 1);
		int[] dp = new int[n + 1];
		int[] dph = new int[n + 2];
		dph[n] = 1;

		for (int i = 1; i <= n; ++i) {
			int time = t.nextInt();
			int x = t.nextInt();
			int y = t.nextInt();
			a[i] = new PAIR(time, x, y);
		}

		for (int i = n; i >= 0; --i) {
			int max = 0;

			for (int j = i + 1; j <= n; ++j) {
				if (a[j].time - a[i].time > 2 * r) {
					max = Math.max(max, dph[j]);
					break;
				}

				if (Math.abs(a[i].x - a[j].x) + Math.abs(a[i].y - a[j].y) <= a[j].time - a[i].time)
					max = Math.max(max, dp[j]);
			}

			dp[i] = max + 1;
			dph[i] = Math.max(dph[i + 1], max + 1);
		}

		o.println(dp[0] - 1);
		o.flush();
		o.close();
	}

	static class PAIR {
		int time;
		int x;
		int y;

		PAIR(int time, int x, int y) {
			this.time = time;
			this.x = x;
			this.y = y;
		}
	}
}
