import java.util.*;
import java.io.*;

public class Minimum_Ties {

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
			--n;

			if ((n & 1) == 0) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n - i; j++) {
						if (j < n / 2) {
							o.print("1 ");
						} else {
							o.print("-1 ");
						}
					}
				}
			} else {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n - i; j++) {
						if (j < n / 2) {
							o.print("1 ");
						} else if (j == n / 2) {
							o.print("0 ");
						} else {
							o.print("-1 ");
						}
					}
				}
			}

			o.println();
		}

		o.flush();
		o.close();
	}
}