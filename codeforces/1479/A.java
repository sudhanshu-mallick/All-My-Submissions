import java.util.*;
import java.io.*;

public class Searching_Local_Minimum {

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
		int n = t.nextInt(), low = 0, high = n;

		while (high - low > 1) {
			int mid = low + ((high - low) >> 1);

			query(mid);

			int l2 = t.nextInt();

			query(mid - 1);

			int l1 = t.nextInt();

			if (l1 < l2)
				high = mid;
			else
				low = mid;
		}

		o.println("! " + (low + 1));

		o.flush();
		o.close();
	}

	private static void query(int pos) {
		PrintWriter o = new PrintWriter(System.out);
		o.println("? " + (pos + 1));
		o.flush();
	}
}