import java.util.*;
import java.io.*;

public class Hacking_Cypher {

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
		String s = t.next();
		long a = t.nextLong();
		long b = t.nextLong();
		int n = s.length();
		long[] x = new long[n];
		long[] y = new long[n];

		x[0] = (s.charAt(0) - '0') % a;

		for (int i = 1; i < s.length(); i++)
			x[i] = (x[i - 1] * 10 + s.charAt(i) - '0') % a;

		y[n - 1] = (s.charAt(n - 1) - '0') % b;
		long cur = 10;

		for (int i = n - 2; i >= 0; i--) {
			y[i] = ((s.charAt(i) - '0') * cur + y[i + 1]) % b;
			cur = (cur * 10) % b;
		}

		boolean flag = false;

		for (int i = 0; i < n - 1; i++) {
			if (x[i] == 0 && y[i + 1] == 0 && s.charAt(i + 1) != '0') {
				o.println("YES");
				o.println(s.substring(0, i + 1));
				o.println(s.substring(i + 1));

				flag = true;
				break;
			}
		}

		if (!flag)
			o.println("NO");

		o.flush();
		o.close();
	}
}