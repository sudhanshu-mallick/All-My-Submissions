import java.util.*;
import java.io.*;

public class Bad_Boy {

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
			long m = t.nextLong();
			long n = t.nextLong();
			long x = t.nextLong();
			long y = t.nextLong();
			long[][] a = { { 1, 1 }, { 1, n }, { m, 1 }, { m, n } };
			long max = 0;
			int mini = 0, minj = 1;

			for (int i = 0; i < 4; ++i) {
				for (int j = i + 1; j < 4; ++j) {
					long d1 = Math.abs(x - a[i][0]) + Math.abs(y - a[i][1]);
					long d2 = Math.abs(x - a[j][0]) + Math.abs(y - a[j][1]);
					long cur = d1 + d2 + Math.abs(a[i][0] - a[j][0]) + Math.abs(a[i][1] - a[j][1]);

					if (cur >= max) {
						max = cur;
						mini = i;
						minj = j;
					}
				}
			}

			o.println(a[mini][0] + " " + a[mini][1] + " " + a[minj][0] + " " + a[minj][1]);
		}

		o.flush();
		o.close();
	}
}