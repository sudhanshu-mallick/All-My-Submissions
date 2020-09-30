import java.util.*;
import java.io.*;

public class Array_Sum {

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
		int test = t.nextInt();

		while (test-- > 0) {
			boolean flag = true;
			int n = t.nextInt();
			int k = t.nextInt();
			int[] a = new int[n];
			int pos = 0;
			int m = 0;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			while (pos < n) {
				Set<Integer> set = new HashSet<>();
				int cur = a[0];
				++m;
				int prev = pos;
				pos = 0;
				a[0] = 0;

				set.add(cur);

				for (int i = 1; i < n; ++i) {
					if (set.size() < k) {
						cur = a[i];
						a[i] = 0;
						pos = i;

						set.add(cur);
					} else {
						if (set.contains(a[i])) {
							pos = i;
							a[i] = 0;
						} else
							a[i] -= cur;
					}
				}

				int sum = 0;

				for (int i = 0; i < n; ++i) {
					sum += a[i];
				}

				if (sum == 0)
					break;

				if (prev == pos) {
					flag = false;
					break;
				}
			}

			if (flag)
				o.println(m);
			else
				o.println("-1");

		}

		o.flush();
		o.close();
	}
}