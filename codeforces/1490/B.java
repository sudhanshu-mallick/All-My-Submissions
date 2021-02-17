import java.util.*;
import java.io.*;

public class Balanced_Reminders {

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
			int c[] = new int[3];
			int res = 0;

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt();

				if (x % 3 == 0)
					++c[0];
				else if (x % 3 == 1)
					++c[1];
				else
					++c[2];
			}

			n /= 3;

			while (Math.min(c[0], Math.min(c[1], c[2])) != n) {
				for (int i = 0; i < 3; ++i) {
					if (c[i] > n) {
						--c[i];
						++res;
						++c[(i + 1) % 3];
					}
				}
			}

			o.println(res);
		}

		o.flush();
		o.close();
	}
}