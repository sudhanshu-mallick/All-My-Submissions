import java.util.*;
import java.io.*;

public class Number_Of_Apartments {

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

			if (n == 1 || n == 2 || n == 4)
				o.println("-1");
			else {
				if (n % 3 == 0)
					o.println(n / 3 + " 0 0");
				else if (n % 3 == 1)
					o.println((n - 7) / 3 + " 0 1");
				else
					o.println((n - 5) / 3 + " 1 0");
			}
		}

		o.flush();
		o.close();
	}
}