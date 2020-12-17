import java.util.*;
import java.io.*;

public class Find_The_Array {

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
			long[] a = new long[n];
			long even = 0, odd = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong();

				if ((i & 1) == 0)
					even += a[i];
				else
					odd += a[i];
			}

			if (even <= odd) {
				for (int i = 0; i < n; ++i) {
					if ((i & 1) == 0)
						o.print("1 ");
					else
						o.print(a[i] + " ");
				}
			} else {
				for (int i = 0; i < n; ++i) {
					if ((i & 1) == 1)
						o.print("1 ");
					else
						o.print(a[i] + " ");
				}
			}

			o.println();
		}

		o.flush();
		o.close();
	}
}