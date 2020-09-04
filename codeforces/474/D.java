import java.util.*;
import java.io.*;

public class Flowers {

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
		int k = t.nextInt();
		long[] a = new long[100001];

		for (int i = 0; i <= 100000; ++i) {
			if (i < k)
				a[i] = 1l;
			else
				a[i] = (a[i - 1] + a[i - k]) % 1000000007;
		}

		for (int i = 1; i < a.length; ++i) {
			a[i] = (a[i] + a[i - 1]) % 1000000007;
		}

		while (test-- > 0) {
			int left = t.nextInt();
			int right = t.nextInt();

			o.println((a[right] - a[left - 1] + 1000000007) % 1000000007);
		}

		o.flush();
		o.close();
	}
}