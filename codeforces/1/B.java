import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Spreadsheet {

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
			String s = "";
			s = t.next();
			int n = s.length();
			StringBuilder r = new StringBuilder();
			StringBuilder c = new StringBuilder();
			StringBuilder a = new StringBuilder();
			int flag = 0;

			for (int i = 0; i < n - 1; i++) {
				char ch1 = s.charAt(i), ch2 = s.charAt(i + 1);

				if ((Character.isAlphabetic(ch1) && Character.isDigit(ch2))
						|| (Character.isAlphabetic(ch2) && Character.isDigit(ch1)))
					flag++;
			}

			if (flag == 1) {
				for (int i = 0; i < n; i++) {
					char ch = s.charAt(i);

					if (Character.isAlphabetic(ch))
						c.append(ch);
					else
						r.append(ch);
				}

				a.append('R');
				a.append(r);
				a.append('C');

				long ans = 0, k = 0;

				for (int i = c.length() - 1; i >= 0; i--) {
					char ch = c.charAt(i);
					int num = ch - 64;
					ans += Math.pow(26, k) * num;
					k++;
				}

				a.append(ans);
			} else {
				int f = 0;

				for (int i = 1; i < n; i++) {
					char ch = s.charAt(i);

					if (ch == 'C') {
						f = 1;
						continue;
					}

					if (f == 0)
						r.append(ch);
					else
						c.append(ch);
				}

				long ans = Long.parseLong(c.toString());
				String sq = "";

				while (ans != 0) {
					char ch = (char) ((ans - 1) % 26 + 'A');
					ans = (ans - 1) / 26;
					sq = ch + sq;
				}

				a.append(sq);
				a.append(r);
			}

			o.println(a);
		}

		o.flush();
		o.close();
	}

}