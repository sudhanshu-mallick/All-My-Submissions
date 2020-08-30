
import java.util.*;
import java.io.*;

public class Juggling_Letters {

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
			int[] a = new int[26];

			for (int i = 0; i < n; ++i) {
				String s = t.next();

				for (char ch : s.toCharArray()) {
					a[ch - 'a']++;
				}
			}

			String s = "YES";

			for (int i = 0; i < 26; ++i) {
				if (a[i] % n != 0)
					s = "NO";
			}

			o.println(s);

		}

		o.flush();
		o.close();
	}
}