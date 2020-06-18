import java.util.*;
import java.io.*;

public class Pasha_And_String {

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
		int n = s.length();
		long[] a = new long[n / 2];
		int m = t.nextInt();

		while (m-- > 0) {
			int x = t.nextInt();
			a[x - 1]++;
		}

		for (int i = 1; i < n / 2; ++i) {
			a[i] += a[i - 1];
		}

		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < n / 2; ++i) {
			if ((a[i] & 1) == 1) {
				ans.append(s.charAt(n - i - 1));
			} else {
				ans.append(s.charAt(i));
			}
		}

		if ((n & 1) == 1)
			ans.append(s.charAt(n / 2));

		for (int i = n / 2 - 1; i >= 0; --i) {
			if ((a[i] & 1) == 1) {
				ans.append(s.charAt(i));
			} else {
				ans.append(s.charAt(n - i - 1));
			}
		}

		o.println(ans);
		o.flush();
		o.close();
	}
}