import java.util.*;
import java.io.*;

public class Ternary_XOR {

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
		int q = t.nextInt();

		while (q-- > 0) {
			int n = t.nextInt();
			String s1 = t.next();
			boolean flag = true;
			StringBuilder sb = new StringBuilder();
			StringBuilder s = new StringBuilder();

			for (int i = 0; i < n; i++) {
				char ch = s1.charAt(i);

				if (ch == '2' && flag) {
					sb.append('1');
					s.append('1');
				} else if (ch == '1' && flag) {
					sb.append('1');
					s.append('0');

					flag = false;
				} else {
					sb.append('0');
					s.append(ch);
				}
			}

			o.println(sb);
			o.println(s);
		}
		o.flush();
		o.close();
	}
}
