import java.util.*;
import java.io.*;

public class Love_Song {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt();
		int q = t.nextInt();
		String s = t.next();
		long[][] dp = new long[n + 1][26];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < 26; ++j)
				dp[i + 1][j] = dp[i][j];

			++dp[i + 1][s.charAt(i) - 'a'];
		}

		while (q-- > 0) {
			int low = t.nextInt() - 1;
			int high = t.nextInt();
			long ans = 0;

			for (int i = 0; i < 26; ++i) {
				ans += (dp[high][i] - dp[low][i]) * (i + 1);
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}