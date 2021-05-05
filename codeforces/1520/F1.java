import java.util.*;
import java.io.*;

public class Guess_The_Kth_Zero {

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

	private static FastReader t = new FastReader();
	private static PrintWriter o = new PrintWriter(System.out);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = t.nextInt();
		int tt = t.nextInt();
		int k = t.nextInt();
		int low = 1, high = n;
		int ans = 1;

		while (low <= high) {
			int mid = (low + high) >> 1;
			int val = mid - query(mid);

			if (val >= k) {
				ans = mid;
				high = mid - 1;
			} else
				low = mid + 1;

		}

		o.println("! " + ans);
		o.flush();
		o.close();
	}

	private static int query(int j) {
		o.println("? 1 " + j);
		o.flush();

		return t.nextInt();
	}
}