import java.util.*;
import java.io.*;

public class Nezzar_And_Symmetric_Array {

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

	public static void shuffle(long[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}
	}

	public static void swap(long[] a, int i, int j) {
		long temp = a[i];
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
			long[] a = new long[2 * n];

			for (int i = 0; i < 2 * n; ++i) {
				a[i] = t.nextLong();
			}

			shuffle(a);
			Arrays.sort(a);

			int i = 2 * n - 1;
			boolean flag = true;
			long cur = 0;
			long times = 2 * n;
			Set<Long> set = new HashSet<>();

			while (i >= 0) {
				if (a[i] != a[i - 1]) {
					flag = false;
					break;
				}

				a[i] -= cur;

				if (a[i] <= 0 || a[i] % times != 0) {
					flag = false;
					break;
				}

				set.add(2 * a[i] / times);

				cur = cur + 2 * a[i] / times;
				times -= 2;
				i -= 2;

			}

			if (flag && set.size() == n)
				o.println("YES");
			else
				o.println("NO");
		}

		o.flush();
		o.close();
	}
}