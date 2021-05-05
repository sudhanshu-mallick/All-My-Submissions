import java.util.*;
import java.io.*;

public class Not_Adjacent_Matrix {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();

			if (n != 2) {
				int[] ans = new int[n * n];
				int cur = 1, i = 0;

				while (i < ans.length && cur <= n * n) {
					ans[i++] = cur;
					cur += 2;
				}

				cur = 2;

				while (i < ans.length && cur <= n * n) {
					ans[i++] = cur;
					cur += 2;
				}

				for (i = 0; i < n; ++i) {
					for (int j = 0; j < n; ++j)
						o.print(ans[i * n + j] + " ");

					o.println();
				}
			} else
				o.println("-1");
		}

		o.flush();
		o.close();
	}
}