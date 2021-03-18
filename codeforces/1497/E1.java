import java.util.*;
import java.io.*;

public class Square_Free_Division {

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
			int count = 1;
			Set<Integer> set = new HashSet<>();

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt();
				int cur = 1;
				int cnt = 0;

				while ((x & 1) == 0) {
					cnt ^= 1;
					x >>= 1;
				}

				if (cnt > 0)
					cur = 2;

				for (int j = 3; j * j <= x; j += 2) {
					if ((x % j) == 0) {
						cnt = 0;

						while (x % j == 0) {
							cnt ^= 1;
							x /= j;
						}

						if (cnt > 0)
							cur *= j;
					}
				}

				if (x > 1)
					cur *= x;

				if (set.contains(cur)) {
					++count;
					set = new HashSet<>();
				}

				set.add(cur);
			}

			o.println(count);
		}

		o.flush();
		o.close();
	}
}