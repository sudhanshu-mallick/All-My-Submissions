import java.util.*;
import java.io.*;

public class String_LCM {

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
		int test = t.nextInt();

		while (test-- > 0) {
			String[] s = new String[2];
			s[0] = t.next();
			s[1] = t.next();
			String x = "", y = "";

			if (s[0].length() > s[1].length()) {
				x = s[1];
				y = s[0];
			} else {
				x = s[0];
				y = s[1];
			}

			int m = x.length();
			int n = y.length();
			StringBuilder cur = new StringBuilder(y);
			boolean res = false;

			while (cur.length() <= m * n) {
				if (check(cur, x, y)) {
					res = true;
					break;
				}

				cur.append(y);
			}

			if (!res)
				o.println("-1");
			else
				o.println(cur);
		}

		o.flush();
		o.close();
	}

	private static boolean check(StringBuilder cur, String x, String y) {
		if (cur.length() % x.length() != 0 || cur.length() % y.length() != 0)
			return false;

		StringBuilder sb = new StringBuilder(x);

		while (sb.length() < cur.length())
			sb.append(x);

		if (!sb.toString().equals(cur.toString()))
			return false;

		sb = new StringBuilder(y);

		while (sb.length() < cur.length())
			sb.append(y);

		if (!sb.toString().equals(cur.toString()))
			return false;

		return true;
	}
}