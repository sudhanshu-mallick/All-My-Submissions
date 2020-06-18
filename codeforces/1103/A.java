import java.util.*;
import java.io.*;

public class Grid_Game {

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
		String s = t.next();
		int b = 0, d = 0;
		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);

			if (ch == '0') {
				b = b % 2 + 1;

				ans.append(b * 2 - 1 + " 1");
				ans.append("\n");
			} else {
				d = d % 4 + 1;

				ans.append(d + " 3");
				ans.append("\n");
			}
		}

		o.println(ans);

		o.flush();
		o.close();
	}
}