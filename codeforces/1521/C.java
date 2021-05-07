import java.util.*;
import java.io.*;

public class Nastia_And_Hidden_Permutation {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n + 1];
			int i = 1, idxOne = -1;

			while (i + 1 <= n) {
				int v1 = query(2, i, i + 1, 1);

				if (v1 == 1) {
					a[i] = 1;
					idxOne = i;
					break;
				} else if (v1 == 2) {
					int v2 = query(2, i + 1, i, 1);

					if (v2 == 1) {
						a[i + 1] = 1;
						idxOne = i + 1;
						break;
					}
				}

				i += 2;
			}

			if (idxOne == -1) {
				idxOne = n;
				a[n] = 1;
			}

			int x = idxOne - 1, y = idxOne + 1;

			while (x > 0) {
				int val = query(1, idxOne, x, n - 1);
				a[x] = val;
				--x;
			}

			while (y <= n) {
				int val = query(1, idxOne, y, n - 1);
				a[y] = val;
				++y;
			}

			o.print("! ");

			for (i = 1; i <= n; ++i)
				o.print(a[i] + " ");

			o.println();
			o.flush();

		}

		o.flush();
		o.close();
	}

	private static FastReader t = new FastReader();
	private static PrintWriter o = new PrintWriter(System.out);

	private static int query(int tt, int i, int j, int x) {
		o.println("? " + tt + " " + i + " " + j + " " + x);
		o.flush();

		return t.nextInt();
	}
}