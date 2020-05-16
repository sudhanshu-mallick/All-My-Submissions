import java.util.*;
import java.io.*;

public class Sequence_With_Digits {

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
			long n = t.nextLong();
			long k = t.nextLong();
			long ans = n;
			k--;

			while (k-- > 0) {
				long min = min(ans);
				long max = max(ans);

				if (min * max == 0)
					break;

				ans += min * max;
			}

			o.println(ans);

		}

		o.flush();
		o.close();
	}

	private static long min(long n) {
		long min = 9;

		while (n > 0) {
			min = Math.min(n % 10, min);
			n /= 10;
		}

		return min;
	}

	private static long max(long n) {
		long max = 0;

		while (n > 0) {
			max = Math.max(n % 10, max);
			n /= 10;
		}

		return max;
	}

}