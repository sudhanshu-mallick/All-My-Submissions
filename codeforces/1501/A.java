import java.util.*;
import java.io.*;

public class Alexey_And_Train {

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
			int[][] a = new int[n][2];
			int[] time = new int[n];
			int cur = 0;
			int prev = 0;

			for (int i = 0; i < n; ++i) {
				a[i][0] = t.nextInt();
				a[i][1] = t.nextInt();
			}

			for (int i = 0; i < n; ++i)
				time[i] = t.nextInt();

			int i = 0;

			while (i < n) {
				int travel = a[i][0] - prev + time[i];
				cur += travel;

				if (i < n - 1)
					cur += Math.max(cur + ((a[i][1] - a[i][0] + 1) >> 1), a[i][1]) - cur;

				prev = a[i][1];
				++i;
			}

			o.println(cur);
		}

		o.flush();
		o.close();
	}
}