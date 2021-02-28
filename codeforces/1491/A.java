import java.util.*;
import java.io.*;

public class Kth_Largest_Value {

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
		int n = t.nextInt();
		int q = t.nextInt();
		int[] a = new int[n];
		int one = 0;

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();
			one += a[i];
		}

		while (q-- > 0) {
			int x = t.nextInt();
			int y = t.nextInt() - 1;

			if (x == 1) {
				a[y] = a[y] ^ 1;

				if (a[y] == 1)
					++one;
				else
					--one;
			} else {
				if (y + 1 > one)
					o.println("0");
				else
					o.println("1");
			}
		}

		o.flush();
		o.close();
	}
}