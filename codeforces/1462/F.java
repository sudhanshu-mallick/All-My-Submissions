import java.util.*;
import java.io.*;

public class The_Treasure_Of_The_Segments {

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
			int[][] a = new int[n][2];
			int[] left = new int[n];
			int[] right = new int[n];

			for (int i = 0; i < n; ++i) {
				a[i][0] = left[i] = t.nextInt();
				a[i][1] = right[i] = t.nextInt();
			}

			shuffle(left);
			shuffle(right);
			Arrays.sort(left);
			Arrays.sort(right);

			int min = n - 1;

			for (int i = 0; i < n; ++i) {
				int ele = a[i][0];
				int low = 0, high = n - 1;
				int cur1 = 0;

				while (low <= high) {
					int mid = low + ((high - low) >> 1);

					if (right[mid] >= ele) {
						high = mid - 1;
					} else {
						low = mid + 1;
						cur1 = low;
					}
				}

				ele = a[i][1];
				low = 0;
				high = n - 1;
				int cur2 = n;

				while (low <= high) {
					int mid = low + ((high - low) >> 1);

					if (left[mid] > ele) {
						cur2 = mid;
						high = mid - 1;
					} else
						low = mid + 1;
				}

				cur2 = n - cur2;
				min = Math.min(min, cur1 + cur2);
			}

			o.println(min);
		}

		o.flush();
		o.close();
	}
}