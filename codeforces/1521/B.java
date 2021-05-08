import java.util.*;
import java.io.*;

public class Nastia_And_A_Good_Array {

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
			int[] a = new int[n];
			int minIdx = -1, min = Integer.MAX_VALUE;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = 0; i < n; ++i) {
				if (a[i] < min) {
					min = a[i];
					minIdx = i;
				}
			}

			o.println(n - 1);

			int i = minIdx - 1;

			while (i >= 0) {
				o.println((i + 1) + " " + (minIdx + 1) + " " + (min + minIdx - i) + " " + min);

				--i;
			}

			i = minIdx + 1;

			while (i < n) {
				o.println((i + 1) + " " + (minIdx + 1) + " " + (min + i - minIdx) + " " + min);

				++i;
			}

		}

		o.flush();
		o.close();
	}
}