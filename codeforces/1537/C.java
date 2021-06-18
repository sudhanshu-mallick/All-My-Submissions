import java.util.*;
import java.io.*;

public class Challenging_Cliffs {

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
			int minDif = Integer.MAX_VALUE, minIdx = 1;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			shuffle(a);

			for (int i = 1; i < n; ++i)
				if (a[i] - a[i - 1] < minDif) {
					minDif = a[i] - a[i - 1];
					minIdx = i;
				}

			o.print(a[minIdx - 1] + " ");

			for (int i = minIdx + 1; i < n; ++i)
				if (a[i] != a[minIdx])
					o.print(a[i] + " ");

			for (int i = 0; i < n; ++i) {
				if (a[i] > a[minIdx])
					break;

				if (i != minIdx && i != minIdx - 1)
					o.print(a[i] + " ");
			}

			o.println(a[minIdx]);
		}

		o.flush();
		o.close();
	}
}