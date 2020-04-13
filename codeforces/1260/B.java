import java.util.*;
import java.io.*;

public class Obtain_Two_Zeros {

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
			long a = t.nextLong(), b = t.nextLong();

			if (a > b) {
				a = a + b - (b = a);
			}

			long n = (2 * a - b) % 3 == 0 ? (2 * a - b) / 3 : -1;

			if (n >= 0 && (a - 2 * n) >= 0)
				o.println("YES");
			else
				o.println("NO");
		}

		o.flush();
		o.close();
	}
}