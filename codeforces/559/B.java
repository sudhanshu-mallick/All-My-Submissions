import java.util.*;
import java.io.*;

public class Equivalent_Strings {

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
		String s1 = t.next();
		String s2 = t.next();

		s1 = equivalent(s1);
		s2 = equivalent(s2);

		if (s1.equals(s2))
			o.println("YES");
		else
			o.println("NO");

		o.flush();
		o.close();
	}

	private static String equivalent(String s) {
		if ((s.length() & 1) == 1)
			return s;

		StringBuilder s1 = new StringBuilder(equivalent(s.substring(0, s.length() >> 1)));
		StringBuilder s2 = new StringBuilder(equivalent(s.substring(s.length() >> 1)));

		if (s1.toString().compareTo(s2.toString()) < 0) {
			return s1.append(s2).toString();
		} else {
			return s2.append(s1).toString();
		}
	}
}