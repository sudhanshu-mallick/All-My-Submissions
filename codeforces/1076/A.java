import java.util.*;
import java.io.*;

public class Minimizing_The_String {

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
		int n = t.nextInt();
		String s = t.next();
		boolean f = false;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n - 1; ++i) {
			char ch = s.charAt(i);
			char ch1 = s.charAt(i + 1);

			if (ch > ch1 && !f) {
				f = true;
				continue;
			}

			sb.append(ch);
		}

		if (f)
			sb.append(s.charAt(n - 1));

		o.println(sb);

		o.flush();
		o.close();
	}
}