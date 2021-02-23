import java.util.*;
import java.io.*;

public class Genius_Gambit {

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
		int a = t.nextInt();
		int b = t.nextInt();
		int k = t.nextInt();
		boolean flag = true;
		char[] A = new char[a + b];
		char[] B = new char[a + b];

		if (k >= 1) {
			--k;
			int n = a + b;
			A[n - 1] = '0';
			B[n - 1] = '1';
			--a;
			int i = n - 2;

			if (a < 0)
				flag = false;

			while (k > 0) {
				if (a > 0) {
					A[i] = B[i] = '0';
					--i;
					--k;
					--a;
				} else if (b > 1) {
					A[i] = B[i] = '1';
					--b;
					--k;
					--i;
				} else {
					flag = false;
					break;
				}
			}

			if (flag) {
				A[i] = '1';
				B[i] = '0';
				--i;
				--b;

				while (a > 0) {
					A[i] = B[i] = '0';
					--i;
					--a;
				}

				while (b > 0) {
					A[i] = B[i] = '1';
					--i;
					--b;
				}
			}

			if (B[0] != '1')
				flag = false;

			if (flag) {
				o.println("Yes");
				o.println(new String(A));
				o.println(new String(B));
			} else {
				o.println("No");
			}
		} else {
			int i = 0;

			while (i < b) {
				A[i] = B[i] = '1';
				++i;
			}

			while (i < a + b) {
				A[i] = B[i] = '0';
				++i;
			}

			o.println("Yes");
			o.println(new String(A));
			o.println(new String(B));
		}

		o.flush();
		o.close();
	}
}