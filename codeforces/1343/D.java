import java.util.*;
import java.io.*;

public class Constant_Palindrome_Sum {

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
			int k = t.nextInt();
			int a[] = new int[n];
			int fre[] = new int[2 * k + 1];
			int pre[] = new int[2 * k + 2];
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = 0; i < n / 2; ++i) {
				fre[a[i] + a[n - i - 1]]++;
				int ma = Math.max(a[i], a[n - i - 1]) + k;
				int mi = Math.min(a[i], a[n - i - 1]) + 1;
				pre[mi]++;
				pre[ma + 1]--;
			}

			for (int i = 1; i < pre.length; ++i) {
				pre[i] = pre[i] + pre[i - 1];
			}

			for (int i = 0; i < n / 2; ++i) {
				pre[a[i] + a[n - i - 1]]--;
			}

			for (int i = 2; i <= 2 * k; ++i) {
				int ans = 0 * (fre[i]) + 1 * (pre[i]) + 2 * (n / 2 - fre[i] - pre[i]);
				min = Math.min(min, ans);
			}

			o.println(min);
		}

		o.flush();
		o.close();
	}
}