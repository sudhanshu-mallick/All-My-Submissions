import java.util.*;
import java.io.*;

public class Modulo_Equality {

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
		int[] a = new int[n];
		int[] b = new int[n];
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		for (int i = 0; i < n; ++i)
			b[i] = t.nextInt();

		shuffle(a);
		shuffle(b);
		Arrays.sort(a);
		Arrays.sort(b);

		for (int i = 0; i < n; ++i) {
			int v = b[i] - a[0];
			boolean res = true;

			if (v < 0)
				v += m;

			for (int j = 0; j < n; ++j) {
				int idx = i + j;

				if (idx >= n)
					idx -= n;

				int val = b[idx] - a[j];

				if (val < 0)
					val += m;

				if (val != v) {
					res = false;
					break;
				}
			}

			if (res & ans > v)
				ans = v;
		}

		o.println(ans);

		o.flush();
		o.close();
	}
}