import java.util.*;
import java.io.*;

public class Corrupted_Array {

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

	public static void shuffle(long[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(long[] a, int i, int j) {
		long temp = a[i];
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
			long[] b = new long[n + 2];
			long[] a = new long[n];
			long sum = 0;
			int ridx = -1, midx = -1;

			for (int i = 0; i < n + 2; ++i) {
				b[i] = t.nextLong();
				sum += b[i];
			}

			shuffle(b);

//			for (long v : b)
//				o.print(v + " ");
//
//			o.println();

			for (int i = n + 1; i >= n; --i) {
				long curSum = b[i];

				for (int j = 0; j < b.length; ++j) {
					if (j != i)
						if (sum - curSum - b[j] == curSum) {
							ridx = j;
							midx = i;
							break;
						}
				}

				if (ridx != -1)
					break;
			}

			if (ridx == -1)
				o.println("-1");
			else {
				int i = 0, j = 0;
				while (i < b.length) {
					if (i != ridx && i != midx)
						a[j++] = b[i];

					++i;
				}

				for (long v : a)
					o.print(v + " ");

				o.println();
			}
		}

		o.flush();
		o.close();
	}
}