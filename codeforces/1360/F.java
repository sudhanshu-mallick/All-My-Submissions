import java.io.*;
import java.util.*;

public class Spy_String {

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
			int m = t.nextInt();
			String s[] = new String[n];
			StringBuilder ans = new StringBuilder();

			for (int i = 0; i < n; ++i)
				s[i] = t.next();

			for (int i = 0; i < m; ++i) {
				for (char ch = 'a'; ch <= 'z'; ++ch) {
					StringBuilder sb = new StringBuilder();

					if (i > 0)
						sb.append(s[0].substring(0, i));

					sb.append(ch);
					sb.append(s[0].substring(i + 1));

					String comp = sb.toString();
					boolean f = true;

					for (int j = 1; j < n; ++j) {
						int count = 0;

						for (int k = 0; k < m; ++k)
							if (comp.charAt(k) != s[j].charAt(k))
								count++;

						if (count > 1) {
							f = false;
							break;
						}
					}

					if (f) {
						ans.append(comp);
						break;
					}
				}

				if (ans.length() > 0)
					break;
			}

			if (ans.length() > 0)
				o.println(ans);
			else
				o.println("-1");
		}

		o.flush();
		o.close();
	}
}