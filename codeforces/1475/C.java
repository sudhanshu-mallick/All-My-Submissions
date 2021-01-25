import java.util.*;
import java.io.*;

public class Balls_In_Berland {

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
			int m = t.nextInt();
			int n = t.nextInt();
			int k = t.nextInt();
			int[] a = new int[m];
			int[] b = new int[n];
			int[][] pair = new int[k][2];

			for (int i = 0; i < k; ++i) {
				int x = t.nextInt() - 1;
				pair[i][0] = x;
				a[x]++;
			}

			for (int i = 0; i < k; ++i) {
				int y = t.nextInt() - 1;
				pair[i][1] = y;
				b[y]++;
			}

			long ans = 0;

			for (int i = 0; i < k; ++i) {
				ans += k - a[pair[i][0]] - b[pair[i][1]] + 1;
			}

			o.println(ans >> 1);
		}

		o.flush();
		o.close();
	}
}