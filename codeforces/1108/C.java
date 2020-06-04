import java.util.*;
import java.io.*;

public class Nice_Garland {

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
		char ch[] = t.next().toCharArray();
		char a[][] = new char[6][n];
		char b[] = { 'R', 'B', 'G' };

		for (int i = 0; i < n; ++i)
			a[0][i] = b[i % 3];

		b = new char[] { 'R', 'G', 'B' };

		for (int i = 0; i < n; ++i)
			a[1][i] = b[i % 3];

		b = new char[] { 'B', 'G', 'R' };

		for (int i = 0; i < n; ++i)
			a[2][i] = b[i % 3];

		b = new char[] { 'B', 'R', 'G' };

		for (int i = 0; i < n; ++i)
			a[3][i] = b[i % 3];

		b = new char[] { 'G', 'R', 'B' };

		for (int i = 0; i < n; ++i)
			a[4][i] = b[i % 3];

		b = new char[] { 'G', 'B', 'R' };

		for (int i = 0; i < n; ++i)
			a[5][i] = b[i % 3];

		int c[] = new int[6];

		for (int i = 0; i < n; ++i) {
			char x = ch[i];

			for (int j = 0; j < 6; ++j) {
				c[j] = c[j] + (x == a[j][i] ? 0 : 1);
			}
		}

		int idx = 0, min = n;

		for (int i = 0; i < 6; ++i) {
			if (min > c[i]) {
				min = c[i];
				idx = i;
			}
		}

		o.println(min);
		o.println(new String(a[idx]));

		o.flush();
		o.close();
	}
}