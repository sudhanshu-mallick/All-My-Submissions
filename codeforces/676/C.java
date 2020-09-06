import java.util.*;
import java.io.*;

public class Vasya_And_String {

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
		int k = t.nextInt();
		String s = t.next();
		int max = 0, cnt = 0;
		int i = 0, j = 0;
		char c = 'a';

		while (i < n) {
			if (s.charAt(i) != c)
				cnt++;

			while (cnt > k && j < i) {
				if (s.charAt(j) != c)
					cnt--;

				j++;
			}

			max = Math.max(max, i - j + 1);
			i++;
		}

		cnt = 0;
		c = 'b';
		i = j = 0;

		while (i < n) {
			if (s.charAt(i) != c)
				cnt++;

			while (cnt > k && j < i) {
				if (s.charAt(j) != c)
					cnt--;

				j++;
			}

			max = Math.max(max, i - j + 1);
			i++;
		}

		o.println(max);
		o.flush();
		o.close();
	}
}