import java.util.*;
import java.io.*;

public class Odd_Selection {

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
			int x = t.nextInt();
			int[] a = new int[n];
			int ev = 0, od = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();

				if ((a[i] & 1) == 0)
					ev++;
				else
					od++;
			}

			if (n == ev)
				o.println("No");
			else if ((x & 1) == 0 && od - n == 0)
				o.println("No");
			else if (x - n == 0 && (od & 1) == 0)
				o.println("No");
			else
				o.println("Yes");

		}

		o.flush();
		o.close();
	}
}