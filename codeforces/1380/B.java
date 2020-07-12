import java.util.*;
import java.io.*;

public class Universal_Solution {

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
			int[] a = new int[3];
			String s = t.next();
			char c = ' ';

			for (int i = 0; i < s.length(); ++i) {
				char ch = s.charAt(i);

				if (ch == 'R')
					a[0]++;
				else if (ch == 'P')
					a[1]++;
				else
					a[2]++;
			}

			if (a[0] >= a[1] && a[0] >= a[2])
				c = 'P';
			else if (a[1] >= a[0] && a[1] >= a[2])
				c = 'S';
			else
				c = 'R';

			for (int i = 0; i < s.length(); ++i)
				o.print(c);

			o.println();
		}

		o.flush();
		o.close();
	}
}