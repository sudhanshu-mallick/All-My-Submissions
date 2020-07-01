import java.util.*;
import java.io.*;

public class A_Cookie_For_You {

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
		;

		while (test-- > 0) {
			long a = t.nextLong();
			long b = t.nextLong();
			long m = t.nextLong();
			long n = t.nextLong();

			if (a + b < m + n) {
				o.println("No");
			} else {
				if (Math.min(a, b) < n) {
					o.println("No");
				} else {
					o.println("Yes");
				}
			}

		}

		o.flush();
		o.close();
	}
}