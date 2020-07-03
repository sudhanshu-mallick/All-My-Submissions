import java.util.*;
import java.io.*;

public class Maximum_Of_Maximum_Of_Minimum {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt();
		int k = t.nextInt();
		int[] a = new int[n];
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();

			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}

		if (k == 1)
			o.println(min);
		else if (k == 2) {
			max = a[0];
			int left[] = new int[n];
			int right[] = new int[n];
			left[0] = a[0];
			right[n - 1] = a[n - 1];

			for (int i = 1; i < n; ++i) {
				left[i] = Math.min(left[i - 1], a[i]);
				right[n - i - 1] = Math.min(a[n - i - 1], right[n - i]);
			}

			for (int i = 0; i < n - 1; ++i) {
				max = Math.max(max, Math.max(left[i], right[i + 1]));
			}

			o.println(max);

		} else
			o.println(max);

		o.flush();
		o.close();
	}
}