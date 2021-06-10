
import java.util.*;
import java.io.*;

public class Stone_Gam {

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
			int[] a = new int[n];
			int minIdx = -1, maxIdx = -1;
			int min = 101, max = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();

				if (a[i] >= max) {
					max = a[i];
					maxIdx = i;
				}

				if (a[i] <= min) {
					min = a[i];
					minIdx = i;
				}
			}

			int left = Math.min(maxIdx, minIdx);
			int right = Math.max(maxIdx, minIdx);
			int ans = 0;

			if (left >= n - 1 - right) {
				ans += n - right + Math.min(right - left, left + 1);
			} else {
				ans += left + 1 + Math.min(n - right, right - left);
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}