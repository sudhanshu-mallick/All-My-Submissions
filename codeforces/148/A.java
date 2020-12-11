import java.util.*;
import java.io.*;

public class Insomnia_Cure {

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
		int a = t.nextInt();
		int b = t.nextInt();
		int c = t.nextInt();
		int d = t.nextInt();
		int e = t.nextInt();
		boolean dp[] = new boolean[e];

		for (int i = a - 1; i < e; i += a)
			dp[i] = true;

		for (int i = b - 1; i < e; i += b)
			dp[i] = true;

		for (int i = c - 1; i < e; i += c)
			dp[i] = true;

		for (int i = d - 1; i < e; i += d)
			dp[i] = true;

		int cnt = 0;

		for (int i = 0; i < e; ++i) {
			if (dp[i])
				++cnt;
		}

		o.println(cnt);
		o.flush();
		o.close();
	}
}