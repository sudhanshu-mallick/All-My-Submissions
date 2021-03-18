import java.util.*;
import java.io.*;

public class Minimum_Grid_Path {

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
			long[] c = new long[n];
			long verMin = Long.MAX_VALUE;
			long horMin = Long.MAX_VALUE;
			long min = Long.MAX_VALUE;

			for (int i = 0; i < n; ++i)
				c[i] = t.nextLong();

			verMin = c[0];
			horMin = c[1];
			min = n * verMin + n * horMin;
			long ver = c[0];
			long hor = c[1];

			for (int i = 2; i < n; ++i) {
				if ((i & 1) == 0) {
					ver += c[i];
					verMin = Math.min(verMin, c[i]);
				} else {
					hor += c[i];
					horMin = Math.min(horMin, c[i]);
				}

				long val = ver + ((long) n - ((i + 2) >> 1)) * verMin + hor + ((long) n - ((i + 1) >> 1)) * horMin;
				min = Math.min(val, min);
			}

			o.println(min);
		}

		o.flush();
		o.close();
	}
}