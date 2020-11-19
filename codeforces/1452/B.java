import java.util.*;
import java.io.*;

public class Toy_Blocks {

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
			long a[] = new long[n];
			long sum = 0;
			long max = 0;
			long ans = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong();
				max = Math.max(max, a[i]);
				sum += a[i];
			}

			long val = Math.max(sum, max * (n - 1)) % (n - 1);

			if (val == 0) {
				ans = Math.max(sum, max * (n - 1)) - sum;
			} else {
				ans = Math.max(sum, max * (n - 1)) - sum + (n - val - 1);
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}