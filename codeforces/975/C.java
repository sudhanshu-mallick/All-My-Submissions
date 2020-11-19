import java.util.*;
import java.io.*;

public class Valhalla_Siege {

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
		int q = t.nextInt();
		long[] a = new long[n + 1];
		long cur = 0;

		for (int i = 1; i <= n; ++i) {
			a[i] = a[i - 1] + t.nextInt();
		}

		while (q-- > 0) {
			long val = t.nextLong() + cur;
			int low = 0, high = n;
			int idx = 0;

			if (val >= a[n]) {
				cur = 0;

				o.println(n);
			} else {
				while (low < high) {
					int mid = (low + high) >> 1;

					if (a[mid] == val) {
						idx = mid;
						break;
					} else if (a[mid] > val) {
						idx = mid - 1;
						high = mid;
					} else {
						idx = mid;
						low = mid + 1;
					}
				}

				cur = val;

				o.println(n - idx);
			}

		}

		o.flush();
		o.close();
	}
}