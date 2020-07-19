import java.util.*;
import java.io.*;

public class Acacious_And_String {

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
			int n = t.nextInt();
			String ch = t.next();
			String s = "abacaba";
			boolean flag = false;

			for (int i = 0; i <= n - s.length(); ++i) {
				StringBuilder sb = new StringBuilder();
				int cnt = 0;

				for (int j = i; j < i + 7; ++j) {
					if (ch.charAt(j) == '?')
						sb.append(s.charAt(j - i));
					else
						sb.append(ch.charAt(j));
				}

				if (sb.toString().equals(s)) {
					String str = ch.substring(0, i);

					str = str.concat(sb.toString());
					str = str.concat(ch.substring(i + 7));

					for (int j = 0; j < n - 6; ++j) {
						if (str.substring(j, j + 7).equals(s))
							cnt++;
					}

					if (cnt == 1) {
						flag = true;

						o.println("Yes");
						for (int k = 0; k < i; ++k) {
							o.print(ch.charAt(k) == '?' ? 'z' : ch.charAt(k));
						}

						o.print(sb);

						for (int k = i + 7; k < n; ++k) {
							o.print(ch.charAt(k) == '?' ? 'z' : ch.charAt(k));
						}

						o.println();

						break;
					}
				}

			}

			if (!flag)
				o.println("No");
		}

		o.flush();
		o.close();
	}

}