import java.util.*;
import java.io.*;

public class Sequence_Transformation {

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
			int[][] boundary = new int[n + 1][2];

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();
				boundary[i + 1][0] = -1;
			}

			for (int i = 0; i < n; ++i) {
				int v = a[i];

				if (i - 1 == boundary[v][0]) {
					boundary[v][0] = i;
				} else {
					boundary[v][0] = i;
					boundary[v][1]++;
				}
			}

			for (int i = 1; i <= n; ++i) {
				if (boundary[i][0] + 1 != n) {
					boundary[i][1]++;
				}
			}

			int min = n;

			for (int i = 1; i <= n; ++i) {
				if (boundary[i][0] != -1) {
					min = Math.min(min, boundary[i][1]);
				}
			}

			o.println(min);
		}

		o.flush();
		o.close();
	}
}