import java.util.*;
import java.io.*;

public class Guessing_The_Greatest {

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

	static FastReader t = new FastReader();
	static PrintWriter o = new PrintWriter(System.out);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = t.nextInt();
		int left = 0, right = n;

		while (right - left > 1) {
			int mid = (left + right) >> 1;
			int sMax = query(left, right - 1);

			if (sMax < mid) {
				if (query(left, mid - 1) == sMax) {
					right = mid;
				} else {
					left = mid;
				}
			} else {
				if (query(mid, right - 1) == sMax) {
					left = mid;
				} else {
					right = mid;
				}
			}
		}

		o.println("! " + right);
		o.flush();
		o.close();
	}

	private static int query(int left, int right) {
		if (left >= right)
			return -1;

		o.println("? " + (left + 1) + " " + (right + 1));
		o.flush();

		return t.nextInt() - 1;
	}
}