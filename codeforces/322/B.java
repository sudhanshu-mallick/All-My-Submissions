import java.util.*;
import java.io.*;

public class Ceil_And_Flowers {

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
		long a = t.nextLong();
		long b = t.nextLong();
		long c = t.nextLong();
		long ra = 0;
		long rb = 0;
		long rc = 0;
		long max = 0;

		if (a >= 1l && b >= 1l && c >= 1l)
			ra = (a - 1) / 3 + (b - 1) / 3 + (c - 1) / 3 + 1;

		if (a >= 2l && b >= 2l && c >= 2l)
			rb = (a - 2) / 3 + (b - 2) / 3 + (c - 2) / 3 + 2;

		if (a >= 3l && b >= 3l && c >= 3l)
			rc = (a - 3) / 3 + (b - 3) / 3 + (c - 3) / 3 + 3;

		max = Math.max(a / 3 + b / 3 + c / 3 + Math.min(a % 3, Math.min(b % 3, c % 3)), Math.max(ra, Math.max(rb, rc)));

		o.println(max);

		o.flush();
		o.close();
	}
}