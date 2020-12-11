import java.util.*;
import java.io.*;

public class Codeforces_Subsequences {

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
		long k = t.nextLong();
		long cur = 1;
		long n = 1;
		char ch[] = "codeforces".toCharArray();

		while (n < k) {
			++cur;
			n = 1;

			for (int i = 0; i < 10; ++i)
				n *= cur;
		}

		if (n > k) {
			int idx = 0;

			while (idx < 10) {
				n /= cur;
				n *= (cur - 1);
				++idx;
			}

			idx = 0;

			while (n < k) {
				n /= (cur - 1);
				n *= cur;
				++idx;
			}

			for (int i = 0; i < idx; ++i) {
				for (int j = 0; j < cur; ++j)
					o.print(ch[i]);
			}

			for (int i = idx; i < 10; ++i)
				for (int j = 0; j < cur - 1; ++j)
					o.print(ch[i]);
		} else {
			for (int i = 0; i < 10; ++i)
				for (int j = 0; j < cur; ++j)
					o.print(ch[i]);
		}

		o.flush();
		o.close();
	}
}