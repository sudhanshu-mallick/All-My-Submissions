import java.util.*;
import java.io.*;

public class Minimal_Cost {

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
		int[] a = new int[100];

		while (test-- > 0) {
			int n = t.nextInt();
			int u = t.nextInt();
			int v = t.nextInt();
			int dif = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();
			}

			for (int i = 1; i < n; ++i)
				dif = Math.max(dif, Math.abs(a[i] - a[i - 1]));

			if (dif >= 2) {
				o.println("0");
			} else if (dif == 1) {
				o.println(Math.min(v, u));
			} else {
				o.println(Math.min(2 * v, u + v));
			}
		}

		o.flush();
		o.close();
	}
}