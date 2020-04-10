import java.util.*;
import java.io.*;

public class Array_Splitting {

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
		int n = t.nextInt(), k = t.nextInt();
		int[] a = new int[n];
		Integer[] diff = new Integer[n - 1];
		long cost = 0;

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();

			if (i > 0)
				diff[i - 1] = a[i] - a[i - 1];
		}

		if (k == n)
			cost = 0;
		else {
			Arrays.sort(diff);

			int j = n - 2;
			cost += a[n - 1] - a[0];

			while (--k > 0) {
				cost -= diff[j--];
			}
		}

		o.println(cost);

		o.flush();
		o.close();
	}
}