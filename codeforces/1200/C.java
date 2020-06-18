import java.util.*;
import java.io.*;

public class Round_Table {

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
		long m = t.nextLong();
		long n = t.nextLong();
		long test = t.nextLong();
		long gcd = gcd(Math.max(m, n), Math.min(m, n));
		long dm = m / gcd;
		long dn = n / gcd;
		StringBuilder sb = new StringBuilder();

		while (test-- > 0) {
			long sx = t.nextLong();
			long sy = t.nextLong() - 1;
			long ex = t.nextLong();
			long ey = t.nextLong() - 1;
			boolean flag = false;

			if (sx == 1 && ex == 1) {
				if (sy / dm == ey / dm)
					flag = true;
			} else if (sx == 1 && ex == 2) {
				if (sy / dm == ey / dn)
					flag = true;
			} else if (sx == 2 && ex == 1) {
				if (sy / dn == ey / dm)
					flag = true;
			} else {
				if (sy / dn == ey / dn)
					flag = true;
			}

			if (flag)
				sb.append("YES\n");
			else
				sb.append("NO\n");

		}

		o.println(sb);
		o.flush();
		o.close();
	}

	private static long gcd(long m, long n) {
		if (n == 0)
			return m;

		return gcd(n, m % n);
	}
}