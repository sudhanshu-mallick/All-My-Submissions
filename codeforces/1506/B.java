import java.util.*;
import java.io.*;

public class Partial_Replacement {

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
			int k = t.nextInt();
			char[] a = t.next().toCharArray();
			char[] b = new String(a).toCharArray();
			int i = 0;

			while (i < n) {
				if (b[i] == '*') {
					b[i] = 'x';
					break;
				}

				++i;
			}

			int j = n - 1;

			while (j >= 0) {
				if (b[j] == '*') {
					b[j] = 'x';
					break;
				}

				--j;
			}

			while (i + k < j) {
				int p = i + k;

				while (b[p] != '*')
					--p;

				b[p] = 'x';
				i = p;
			}

			int count = 0;

			for (i = 0; i < n; ++i)
				if (a[i] != b[i])
					++count;

			o.println(count);
		}

		o.flush();
		o.close();
	}
}