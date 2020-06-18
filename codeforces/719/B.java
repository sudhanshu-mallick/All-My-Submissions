import java.util.*;
import java.io.*;

public class Anatoly_And_Cockroaches {

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
		char[] ch = t.next().toCharArray();
		int a = 0, b = 0, c = 0, d = 0;

		for (int i = 0; i < n; ++i) {
			if (ch[i] == 'r') {
				if ((i & 1) == 0) {
					c++;
				} else {
					a++;
				}
			} else {
				if ((i & 1) == 0) {
					b++;
				} else {
					d++;
				}
			}
		}

		o.println(Math.min(Math.max(a, b), Math.max(c, d)));
		o.flush();
		o.close();
	}
}