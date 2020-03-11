import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Comparing_Two_Long_Integers {

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
		OutputStream out = System.out;
		PrintWriter o = new PrintWriter(out);
		StringBuilder s1 = new StringBuilder(t.next());
		StringBuilder s2 = new StringBuilder(t.next());
		int m = s1.length();
		int n = s2.length();

		if (s1.length() == s2.length()) {
			if (s1.compareTo(s2) < 0)
				o.print("<");
			else if (s1.compareTo(s2) > 0)
				o.print(">");
			else
				o.print("=");
		} else {
			if (m > n) {
				String p = s2.toString();
				s2 = new StringBuilder();

				for (int i = 0; i < m - n; i++) {
					s2.append('0');
				}

				s2.append(p);
			} else {
				String p = s1.toString();
				s1 = new StringBuilder();

				for (int i = 0; i < n - m; i++) {
					s1.append('0');
				}

				s1.append(p);
			}

			if (s1.compareTo(s2) < 0)
				o.print("<");
			else if (s1.compareTo(s2) > 0)
				o.print(">");
			else
				o.print("=");
		}

		o.close();
	}

}
