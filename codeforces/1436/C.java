import java.util.*;
import java.io.*;

public class Binary_Search {

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
		long n = t.nextLong();
		long x = t.nextLong();
		int pos = t.nextInt();
		long mod = 1000000007;
		long left = 0, right = n;
		long ans = 1;
		long small = x - 1, large = n - x;

		while (left < right) {
			long mid = (left + right) >> 1;

			if (mid < pos) {
				ans = (ans * small) % mod;
				--small;
				left = mid + 1;
			} else if (mid == pos) {
				left = mid + 1;
			} else {
				ans = (ans * large) % mod;
				--large;
				right = mid;
			}
		}

		small += large;

		while (small > 0) {
			ans = (ans * small) % mod;
			--small;
		}

		o.println(ans);
		o.flush();
		o.close();
	}
}