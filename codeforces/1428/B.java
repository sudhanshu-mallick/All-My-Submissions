import java.util.*;
import java.io.*;

public class Belted_Rooms {

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
			char[] ch = t.next().toCharArray();
			int x = 0, y = 0;
			char cur = '-';

			for (int i = 1; i <= n; ++i) {
				int i1 = (i) % n;
				int i2 = (i + 1) % n;

				if (ch[i1] == '-' || ch[i2] == '-') {
					x++;
				} else {
					cur = ch[i1];
					y++;
				}
			}

			if (y == 0)
				o.println(n);
			else {
				boolean flag = true;

				for (char c : ch) {
					if (c != '-' && c != cur) {
						flag = false;
						break;
					}
				}

				if (flag)
					o.println(n);
				else
					o.println(x);
			}
		}

		o.flush();
		o.close();
	}
}