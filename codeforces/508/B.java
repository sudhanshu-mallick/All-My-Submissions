import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Anton {

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
		StringBuilder s = new StringBuilder(t.next());
		int c = 0, flag = 0, n = s.length() - 1;

		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			int num = (int) ch - 48;

			if (num % 2 == 0) {
				flag = 1;

				if (num > (int) s.charAt(n) - 48)
					c++;
				else {
					flag = 2;
					s.replace(i, i + 1, s.charAt(n) + "");
					s.replace(n, n + 1, ch + "");
					break;
				}
			}
		}

		if (flag == 2)
			o.println(s);
		else if (flag == 0)
			o.println(-1);
		else {
			for (int i = n - 1; i >= 0; i--) {
				char ch = s.charAt(i);
				int num = (int) ch - 48;

				if (num % 2 == 0) {
					s.replace(i, i + 1, s.charAt(n) + "");
					s.replace(n, n + 1, ch + "");
					break;
				}
			}

			o.println(s);
		}

		o.flush();
		o.close();
	}

}
