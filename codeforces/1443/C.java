import java.util.*;
import java.io.*;

public class The_Delivery_Dilemma {

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
			long[][] a = new long[n][2];

			for (int i = 0; i < n; ++i)
				a[i][0] = t.nextLong();

			for (int i = 0; i < n; ++i)
				a[i][1] = t.nextLong();

			Arrays.sort(a, (x, y) -> x[0] > y[0] ? 1 : x[0] == y[0] ? 0 : -1);

			long sum = 0;
			long min = Long.MAX_VALUE;

			for (int i = n - 1; i >= 0; --i) {
				min = Math.min(min, Math.max(a[i][0], sum));
				sum += a[i][1];
			}

			min = Math.min(min, sum);

			o.println(min);
		}

		o.flush();
		o.close();
	}
}