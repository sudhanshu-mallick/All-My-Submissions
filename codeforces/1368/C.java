import java.util.*;
import java.io.*;

public class Beautiful_Picture {

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
		long n = t.nextLong();
		int p = 1, q = 1;
		int[][] a = { { 1, 0 }, { 2, 0 }, { 0, 1 }, { 2, 2 }, { 2, 1 }, { 0, 2 }, { 1, 2 } };

		o.println(4 + 7 * n);
		o.println("0 0");
		o.println("1 0");
		o.println("0 1");
		o.println("1 1");

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < 7; ++j) {
				o.print(a[j][0] + p);
				o.print(" ");
				o.println(a[j][1] + q);
			}

			p += 2;
			q += 2;
		}

		o.flush();
		o.close();
	}
}