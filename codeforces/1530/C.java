import java.util.*;
import java.io.*;

public class Pursuit {

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

		int i = 0, j = a.length - 1;

		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			++i;
			--j;
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
			int[] me = new int[n];
			int[] ilya = new int[n];

			for (int i = 0; i < n; ++i)
				me[i] = t.nextInt();

			for (int i = 0; i < n; ++i)
				ilya[i] = t.nextInt();

			shuffle(me);
			shuffle(ilya);

			for (int i = 1; i < n; ++i) {
				me[i] += me[i - 1];
				ilya[i] += ilya[i - 1];
			}

			int count = n;
			int left = n, right = n << 1;

			while (left <= right) {
				int mid = (left + right) >> 1;
				int ele = mid - (mid >> 2);
				int rem = ele - (mid - n);
				int meScore = rem > 0 ? (me[rem - 1] + 100 * (mid - n)) : (me[n - 1]);
				int ilyaScore = ilya[Math.min(ele, n) - 1];

//				System.out.println(meScore + " " + ilyaScore + " " + mid);

				if (meScore >= ilyaScore) {
					right = mid - 1;
					count = mid;
				} else {
					left = mid + 1;
				}
			}

			o.println(count - n);
		}

		o.flush();
		o.close();
	}
}