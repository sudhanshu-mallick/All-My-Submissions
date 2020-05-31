import java.util.*;
import java.io.*;

public class Subsequence_Hate {

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
			String s = t.next();
			int[] a = new int[s.length() + 2];
			int n = s.length();
			int c = 0;

			for (int i = 0; i < s.length(); ++i) {
				int m = s.charAt(i) - '0';
				c = c + m;
				a[i] = c;
			}

			int min = Math.min(c, n - c);
			;

			for (int i = 1; i < n; ++i) {
				int v1 = a[i - 1];
				int v2 = n - i - c + a[i - 1];
				int v3 = c - a[i - 1];
				int v4 = i - a[i - 1];

//				System.out.println(v1 + v2 + " " + a[i-1]);
				min = Math.min(v1 + v2, Math.min(min, v3 + v4));
			}

			o.println(min);

		}

		o.flush();
		o.close();
	}
}