import java.util.*;
import java.io.*;

public class Three_Indices {

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
			int n = t.nextInt();
			int[] a = new int[n];
			int left[] = new int[n];
			int right[] = new int[n];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			left[0] = a[0];
			right[n - 1] = a[n - 1];
			boolean flag = false;
			int idx = -1;

			for (int i = 1; i < n; ++i) {
				left[i] = Math.min(left[i - 1], a[i]);
				right[n - i - 1] = Math.min(right[n - i], a[n - i - 1]);
			}

			for (int i = 1; i < n - 1; ++i) {
				if (a[i] > left[i - 1] && a[i] > right[i + 1]) {
					flag = true;
					idx = i;
				}
			}

			if (flag) {
				o.println("YES");

				for (int i = 0; i < n; ++i) {
					if (a[i] == left[idx - 1]) {
						o.print(i + 1 + " ");
						break;
					}
				}

				o.print(idx + 1 + " ");

				for (int i = n - 1; i >= 0; --i) {
					if (a[i] == right[idx + 1]) {
						o.println(i + 1);
						break;
					}
				}
			} else {
				o.println("NO");
			}
		}

		o.flush();
		o.close();
	}
}