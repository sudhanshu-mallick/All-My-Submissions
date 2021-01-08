import java.util.*;
import java.io.*;

public class Hills_And_Valleys {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n];
			int count = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();
			}

			for (int i = 1; i < n - 1; ++i) {
				if (a[i] > a[i - 1] && a[i] > a[i + 1])
					++count;
				else if (a[i] < a[i - 1] && a[i] < a[i + 1])
					++count;
			}

			int min = count;

			for (int i = 1; i < n - 1; ++i) {
				if (i > 0 && i < n - 1 && a[i] > a[i - 1] && a[i] > a[i + 1])
					min = Math.min(min, count - check(a, i, n) - 1);
				else if (i > 0 && i < n - 1 && a[i] < a[i - 1] && a[i] < a[i + 1])
					min = Math.min(min, count - check(a, i, n) - 1);
				else
					min = Math.min(min, count - check(a, i, n));
			}

			o.println(min);
		}

		o.flush();
		o.close();
	}

	private static int check(int[] a, int i, int n) {
		int v1 = 0, v2 = 0;

		if (i > 1 && ((a[i - 1] > a[i - 2] && a[i - 1] > a[i]) || (a[i - 1] < a[i - 2] && a[i - 1] < a[i])))
			++v1;

		if (i < n - 2 && ((a[i + 1] > a[i + 2] && a[i + 1] > a[i]) || (a[i + 1] < a[i + 2] && a[i + 1] < a[i])))
			++v1;

		if (i < n - 2 && ((a[i + 1] > a[i + 2] && a[i + 1] > a[i - 1]) || (a[i + 1] < a[i + 2] && a[i + 1] < a[i - 1])))
			--v1;

		if (i > 1 && ((a[i - 1] > a[i - 2] && a[i - 1] > a[i]) || (a[i - 1] < a[i - 2] && a[i - 1] < a[i])))
			++v2;

		if (i < n - 2 && ((a[i + 1] > a[i + 2] && a[i + 1] > a[i]) || (a[i + 1] < a[i + 2] && a[i + 1] < a[i])))
			++v2;

		if (i > 1 && ((a[i - 1] > a[i - 2] && a[i - 1] > a[i + 1]) || (a[i - 1] < a[i - 2] && a[i - 1] < a[i + 1])))
			--v2;

		return Math.max(v1, v2);

	}
}