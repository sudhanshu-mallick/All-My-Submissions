import java.util.*;
import java.io.*;

public class Random_Events {

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
			int k = t.nextInt();
			int[] a = new int[n];
			Pair p[] = new Pair[k];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int j = 0; j < k; ++j) {
				p[j] = new Pair(t.nextInt(), t.nextDouble());
			}

			int j = n - 1;

			while (j >= 0 && a[j] == j + 1)
				--j;

			double ans = 0.0d;
			double now = 1.0d;

			for (int i = 0; i < k; ++i) {
				if (p[i].idx <= j)
					continue;

				ans = ans + now * p[i].prob;
				now = now * (1 - p[i].prob);
			}

			if (j == -1)
				ans = 1.0d;

			o.println(ans);
		}

		o.flush();
		o.close();
	}

	public static class Pair {
		int idx;
		double prob;

		Pair(int idx, double prob) {
			this.idx = idx;
			this.prob = prob;
		}
	}
}