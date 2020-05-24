import java.io.*;
import java.util.*;

public class Buying_Shovels {

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
			long k = t.nextLong();
			long ans = 1;

			for (long i = 1; i * i <= n; i++) {
				if (n % i == 0) {
					if (n / i == i) {
						if (i <= k)
							ans = Math.max(ans, i);
					}
						else {
							if (i <= k)
								ans = Math.max(ans, i);

							if (n / i <= k)
								ans = Math.max(ans, n / i);
						}
				}
			}

			o.println(n / ans);

		}

		o.flush();
		o.close();
	}
}