import java.util.*;
import java.io.*;

public class Preparation_For_IWD {

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
		int n = t.nextInt(), k = t.nextInt(), count = 0;
		int[] a = new int[101];

		for (int i = 0; i < n; ++i)
			a[t.nextInt() % k]++;

		a[0] = a[k] = a[0] / 2;

		if ((k & 1) == 0)
			a[k / 2] = a[k / 2] >> 1;

		for (int i = 0; i <= k / 2; ++i)
			count += 2 * Math.min(a[i], a[k - i]);

		o.println(count);

		o.flush();
		o.close();
	}
}