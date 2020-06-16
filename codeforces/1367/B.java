import java.util.*;
import java.io.*;

public class Even_Array {

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
			int odd = 0, even = 0;

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt();

				if ((i & 1) == 0 && (x & 1) == 1)
					odd++;
				else if ((i & 1) == 1 && (x & 1) == 0)
					even++;
			}

			if (even == odd)
				o.println((odd + even) >> 1);
			else
				o.println("-1");
		}

		o.flush();
		o.close();
	}
}