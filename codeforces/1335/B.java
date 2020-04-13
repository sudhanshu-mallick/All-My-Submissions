import java.util.*;
import java.io.*;

public class Construct_The_String {

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
			int a = t.nextInt();
			int b = t.nextInt();
			char ch[] = new char[26];
			StringBuilder ans = new StringBuilder();

			for (int i = 0; i < 26; ++i)
				ch[i] = (char) (i + 'a');

			for (int i = 0; i < n; ++i) {
				ans.append(ch[i % b]);
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}