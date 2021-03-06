import java.util.*;
import java.io.*;

public class Number_Of_Pairs {

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
			int l = t.nextInt();
			int r = t.nextInt();
			int[] a = new int[n];
			long ans = 0;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			shuffle(a);

			int right = n - 1;
			int left = n - 1;
			int i = 0;

			while (i < n) {
				right = Math.max(right, i);
				left = Math.max(left, i);
				while (right > i && a[i] + a[right] > r)
					--right;

				while (left > i && a[i] + a[left] >= l)
					--left;

//				System.out.println(left + " " + right);

				if (right > left)
					ans += right - left;

				++i;
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}