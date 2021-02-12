import java.util.*;
import java.io.*;

public class Functions_Again {

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

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		long[] dif = new long[n - 1];

		for (int i = 1; i < n; ++i)
			dif[i - 1] = Math.abs(a[i] - a[i - 1]) * ((i & 1) == 1 ? +1 : -1);

		long max1 = kadane(0, dif);

		for (int i = 0; i < n - 1; ++i)
			dif[i] = -dif[i];

		long max2 = kadane(1, dif);

		o.println(Math.max(max1, max2));
		o.flush();
		o.close();
	}

	private static long kadane(int i, long[] dif) {
		int n = dif.length;
		long maxSum = Integer.MIN_VALUE;
		long curSum = 0;

		while (i < n) {
			curSum += dif[i];
			maxSum = Math.max(maxSum, curSum);

			if (curSum < 0)
				curSum = 0;

			++i;
		}

		return maxSum;
	}
}