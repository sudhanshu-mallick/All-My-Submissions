import java.util.*;
import java.io.*;

public class Decrease_The_Sum_Of_Digits {

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
			String s = t.next();
			long n = Long.parseLong(s);
			long ans = n;
			int sum = t.nextInt();
			int i = s.length() - 1;

			while (true) {
				if (sumOfDigits(ans) <= sum) {
					break;
				}

				long cur = (long) Math.pow(10, s.length() - i);
				ans = n + cur - Long.parseLong(s.substring(i));
				--i;
			}

			o.println(ans - n);
		}

		o.flush();
		o.close();
	}

	private static int sumOfDigits(long n) {
		int sum = 0;

		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}

		return sum;
	}
}