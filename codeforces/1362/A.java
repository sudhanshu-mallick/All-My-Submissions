import java.util.*;
import java.io.*;

public class Johhny_And_Ancient_Computer {

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
			long aa = t.nextLong();
			long bb = t.nextLong();
			long a = Math.max(aa, bb);
			long b = Math.min(aa, bb);

			if (a % b != 0) {
				o.println("-1");
			} else {
				long c = a / b;
				int count = 0, p = -1;

				while (c > 0) {
					count += (c & 1);
					c = c >> 1;
					p++;
				}

				if (count > 1)
					o.println("-1");
				else {
					int ans = 0;
					while (p >= 3) {
						p -= 3;
						ans++;
					}

					if (p > 0)
						ans++;

					o.println(ans);
				}

			}

		}

		o.flush();
		o.close();
	}
}