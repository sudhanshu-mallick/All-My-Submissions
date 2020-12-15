import java.util.*;
import java.io.*;

public class Add_To_Neighbour_AndR_Remove {

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
			int[] a = new int[n];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			int min = n - 1;

			for (int i = 0; i < n; ++i) {
				int sum = 0;
				int partition = 0;
				boolean right = true;

				for (int j = 0; j <= i; ++j)
					sum += a[j];

				int j = 0;
				int cur = 0;

				while (j < n) {
					cur += a[j];

					if (cur < sum) {

					} else if (cur == sum) {
						if (j != n - 1) {
							partition++;
							cur = 0;
						}
					} else {
						right = false;
						break;
					}

					++j;
				}

				if (right && cur == sum)
					min = Math.min(min, n - 1 - partition);
			}

			o.println(min);
		}

		o.flush();
		o.close();
	}
}