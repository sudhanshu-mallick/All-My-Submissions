import java.util.*;
import java.io.*;

public class Dreamoon_Likes_Coloring {

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
		int n = t.nextInt();
		int m = t.nextInt();
		int[] a = new int[m];
		boolean flag = true;
		long sum = 0;
		int[] ans = new int[n];

		for (int i = 0; i < m; ++i) {
			a[i] = t.nextInt();

			if (n - a[i] < i) {
				flag = false;
			}

			sum += a[i];
		}

		if (sum < n)
			flag = false;

		if (flag) {
			int i = m - 1;
			int left = n - 1;

			while (i >= 0) {
				left = left - a[i];

				if (left >= i) {
					ans[left + 1] = i + 1;
				} else {
					ans[i] = i + 1;
					left = -1;
				}

				--i;
			}

			int cur = 1;

			for (i = 0; i < n; ++i) {
				if (ans[i] == cur) {
					o.print(i + 1 + " ");

					++cur;
				}
			}

			for (i = 0; i < m; ++i) {

			}

		} else {
			o.println("-1");
		}

		o.flush();
		o.close();
	}
}