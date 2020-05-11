import java.util.*;
import java.io.*;

public class Divisor_Substraction {

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
		long ans = 0;

		if (n % 2 == 0) {
			ans = n / 2;
		} else {
			for (long i = 3; i * i <= n; ++i) {
				if (n % i == 0) {
					ans = 1;
					n -= i;
					break;
				}
			}

			if (ans == 0)
				ans = 1;
			else
				ans += n / 2;
		}

		o.println(ans);

		o.flush();
		o.close();
	}
}