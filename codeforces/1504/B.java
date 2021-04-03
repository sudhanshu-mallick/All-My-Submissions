import java.util.*;
import java.io.*;

public class Flip_The_Bits {

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
			char[] a = t.next().toCharArray();
			char[] b = t.next().toCharArray();
			int one = 0, zero = 0;
			int nof = 0;
			boolean flag = true;

			for (char ch : a)
				if (ch == '1')
					++one;
				else
					++zero;

			int i = n - 1;

			while (i >= 0) {
				int v1 = a[i] - '0';
				int v2 = b[i] - '0';

				if ((v1 ^ nof) != v2) {
					if (zero == one) {
						nof ^= 1;
					} else {
						flag = false;

						break;
					}
				}

				if ((v1 ^ nof) == 0)
					--zero;
				else
					--one;

				--i;
			}

			o.println(flag ? "YES" : "NO");

		}

		o.flush();
		o.close();
	}
}
