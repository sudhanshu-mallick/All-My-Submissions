import java.util.*;
import java.io.*;

public class Maximum_Sum_Of_Products {

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
		int n = t.nextInt();
		long[] a = new long[n];
		long[] b = new long[n];
		long max = 0, total = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		for (int i = 0; i < n; ++i) {
			b[i] = t.nextLong();
			total += a[i] * b[i];
		}

		max = total;

		for (int i = 0; i < n; ++i) {
			int x = i - 1, y = i + 1;
			long cur = total;

			while (x >= 0 && y < n) {
				cur = cur - a[x] * b[x] - a[y] * b[y] + a[x] * b[y] + a[y] * b[x];
				--x;
				++y;
				max = Math.max(max, cur);
			}
		}

		for (int i = 0; i < n; ++i) {
			long cur = total;
			int x = i, y = i + 1;

			while (x >= 0 && y < n) {
				cur = cur - a[x] * b[x] - a[y] * b[y] + a[x] * b[y] + a[y] * b[x];
				--x;
				++y;
				max = Math.max(max, cur);
			}
		}

		o.println(max);
		o.flush();
		o.close();
	}
}