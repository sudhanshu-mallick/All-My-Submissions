import java.util.*;
import java.io.*;

public class Strange_Birthday_Party {

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
			int m = t.nextInt();
			long[] a = new long[n];
			long[] b = new long[m];
			long ans = 0;
			long[] A = new long[m];

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong() - 1;
				++A[(int) a[i]];
			}

			for (int i = 0; i < m; ++i)
				b[i] = t.nextLong();

			int cur = n;
			int i = 0;

			while (cur > 0) {
				if (A[i] < cur) {
					ans += (A[i] + 1) * b[i];
					cur -= (A[i] + 1);
				} else {
					ans += (Math.min(A[i] + 1, cur)) * b[i];
					break;
				}

				++i;
			}

			o.println(ans);

		}

		o.flush();
		o.close();
	}
}