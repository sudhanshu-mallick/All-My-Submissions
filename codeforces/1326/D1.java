import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Pre_Suf_Palin {

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
			StringBuilder s = new StringBuilder(t.next());
			StringBuilder res = new StringBuilder();
			int len = 0;

			for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
				if (s.charAt(i) == s.charAt(j))
					len++;
				else
					break;
			}

			StringBuilder rem = new StringBuilder(s.substring(len, s.length() - len));
			res.append(s.substring(0, len));

			if (rem.length() > 0) {
				int lp = pre_pal(rem.toString());

				rem.reverse();

				int ls = pre_pal(rem.toString());

				if (lp > ls) {
					rem.reverse();
					res.append(rem.substring(0, lp));
				} else
					res.append(rem.substring(0, ls));
			}

			res.append(s.substring(s.length() - len));

			o.println(res);
		}

		o.flush();
		o.close();
	}

	private static int KMP(String s) {
		int[] a = new int[s.length()];

		for (int i = 1; i < s.length(); i++) {
			int pi = a[i - 1];

			while (pi > 0 && s.charAt(i) != s.charAt(pi)) {
				pi = a[pi - 1];
			}

			a[i] = pi + (s.charAt(i) == s.charAt(pi) ? 1 : 0);
		}

		return a[s.length() - 1];
	}

	private static int pre_pal(String s) {
		StringBuilder sb = new StringBuilder();

		sb.append(s);
		sb.append("-");

		StringBuffer p = new StringBuffer(s);

		p.reverse();
		sb.append(p);

		return KMP(sb.toString());
	}

}
