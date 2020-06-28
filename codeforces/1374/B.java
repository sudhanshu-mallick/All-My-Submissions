import java.util.*;
import java.io.*;

public class Mul_Div {

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
			long n = t.nextLong();
			long two = 0, three = 0;

			while (n > 1 && n % 2 == 0) {
				n /= 2;
				two++;
			}

			while (n > 1 && n % 3 == 0) {
				three++;
				n /= 3;
			}

			if (n != 1)
				o.println("-1");
			else {
				long ans = 0;
				if (two <= three)
					ans = three - two + three;
				else
					ans = -1;

				o.println(ans);
			}
		}

		o.flush();
		o.close();
	}
}
