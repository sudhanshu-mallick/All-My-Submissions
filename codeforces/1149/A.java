import java.util.*;
import java.io.*;

public class Prefix_Sum_Prices {

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
		int two = 0, one = 0;

		for (int i = 0; i < n; ++i) {
			int a = t.nextInt();

			if ((a & 1) == 0)
				two++;
			else
				one++;
		}

		if (one == 0) {
			while (two-- > 0)
				o.print(2 + " ");
		} else {
			if (two >= 1) {
				o.print(2 + " " + 1 + " ");

				while (two-- > 1)
					o.print(2 + " ");

				while (one-- > 1)
					o.print(1 + " ");
			} else {
				while (one-- > 0)
					o.print(1 + " ");
			}
		}

		o.flush();
		o.close();
	}
}