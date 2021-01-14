import java.util.*;
import java.io.*;

public class No_More_Inversions {

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
			int k = t.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			int[] p = new int[k];
			a[0] = 0;

			for (int i = 0; i < n; ++i) {
				if ((i + 1) <= k) {
					a[i] = i + 1;
				} else {
					a[i] = k - (i + 1 - k);
				}
			}

			int idx = (k - 1) * 2 - (n - 1);

			for (int i = 0; i < idx; ++i)
				b[i] = a[i];

			b[idx] = b[n - 1] = k;
			int cur = k - 1;

			for (int i = idx + 1; i < k; ++i) {
				b[i] = cur--;
			}

			++cur;

			for (int i = k; i < n - 1; ++i)
				b[i] = ++cur;

			for (int i = 0; i < n; ++i) {
				p[a[i] - 1] = b[i];
			}

			for (int i = 0; i < k; ++i)
				o.print(p[i] + " ");

			o.println();

		}

		o.flush();
		o.close();
	}
}