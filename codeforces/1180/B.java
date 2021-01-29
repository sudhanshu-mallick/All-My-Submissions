import java.util.*;
import java.io.*;

public class Nick_And_Array {

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
		int[] a = new int[n];
		int zeros = 0;
		int max = 0;
		int min = Integer.MAX_VALUE;
		int idx = -1;

		for (int i = 0; i < n; ++i) {
			int x = t.nextInt();

			if (x >= 0)
				a[i] = -x - 1;
			else
				a[i] = x;

			if (min > a[i]) {
				idx = i;
				min = a[i];
			}
		}

		if ((n & 1) == 1)
			a[idx] = -a[idx] - 1;

		for (int v : a) {
			o.print(v + " ");
		}

		o.flush();
		o.close();
	}
}
