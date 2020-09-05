import java.util.*;
import java.io.*;

public class Two_Platforms {

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
			long k = t.nextLong();
			Long[] x = new Long[n];
			long[] y = new long[n];

			for (int i = 0; i < n; ++i)
				x[i] = t.nextLong();

			for (int i = 0; i < n; ++i)
				y[i] = t.nextLong();

			Arrays.sort(x);

			o.println(okgoogle(x, n, k));
		}

		o.flush();
		o.close();
	}

	private static int okgoogle(Long[] x, int n, long k) {
		int ans = 0;

		if (n == 1)
			return 1;

		int[] left = new int[n];
		int[] right = new int[n];

		int i = 0, j = 0;

		while (j < n) {
			if (x[j].longValue() - x[i].longValue() <= k) {
				if (j > 0) {
					left[j] = Math.max(Math.max(left[j], j - i + 1), left[j - 1]);
				} else {
					left[j] = j - i + 1;
				}

				++j;
			} else {
				++i;
			}
		}

		i = j = n - 1;

		while (i >= 0) {
			if (x[j].longValue() - x[i].longValue() <= k) {
				if (i != n - 1) {
					right[i] = Math.max(right[i + 1], Math.max(right[i], j - i + 1));
				} else {
					right[i] = j - i + 1;
				}

				--i;
			} else
				--j;
		}

		for (i = 0; i < n - 1; ++i)
			ans = Math.max(ans, right[i + 1] + left[i]);

		return ans;
	}
}