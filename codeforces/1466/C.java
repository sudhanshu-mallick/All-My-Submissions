import java.util.*;
import java.io.*;

public class Canine_Poetry {

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
			char ch[] = t.next().toCharArray();
			int n = ch.length;
			boolean vis[] = new boolean[n];
			int count = 0;

			for (int i = 0; i < n - 1; ++i) {
				if (vis[i] == true) {
					++count;
					continue;
				}

				if (ch[i] == ch[i + 1]) {
					vis[i + 1] = true;
				}

				if (i + 2 < n && ch[i] == ch[i + 2]) {
					vis[i + 2] = true;
				}
			}

			if (vis[n - 1])
				++count;

			o.println(count);
		}

		o.flush();
		o.close();
	}
}