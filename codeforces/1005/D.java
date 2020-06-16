import java.util.*;
import java.io.*;

public class Polycarp_And_Div_3 {

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
		String sb = t.next();
		StringBuilder s = new StringBuilder();

		for (int i = 0; i < sb.length(); ++i) {
			int n = sb.charAt(i) - '0';
			s.append(n % 3);
		}

		int count = 0;
		int n = sb.length();

		for (int i = 0; i < sb.length(); ++i) {
			if (s.charAt(i) == '0') {
				count++;
			} else if (s.charAt(i) == '2' && i + 1 < n && s.charAt(i + 1) == '1') {
				count++;
				i++;
			} else if (s.charAt(i) == '1' && i + 1 < n && s.charAt(i + 1) == '2') {
				count++;
				i++;
			} else if (s.charAt(i) == '2' && i + 1 < n && s.charAt(i + 1) == '2' && i + 2 < n
					&& s.charAt(i + 2) == '2') {
				count++;
				i += 2;
			} else if (s.charAt(i) == '1' && i + 1 < n && s.charAt(i + 1) == '1' && i + 2 < n
					&& s.charAt(i + 2) == '1') {
				count++;
				i += 2;
			}
		}

		o.println(count);

		o.flush();
		o.close();
	}
}