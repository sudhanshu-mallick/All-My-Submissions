import java.util.*;
import java.io.*;

public class Array_Cancellation {

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
		StringBuilder sb = new StringBuilder();

		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			long sum = 0;
			long max = 0;

			for (int i = n - 1; i >= 0; --i) {
				sum += a[i];

				max = max <= sum ? sum : max;
			}

			sb.append(max + "\n");
		}

		o.println(sb);

		o.flush();
		o.close();
	}
}