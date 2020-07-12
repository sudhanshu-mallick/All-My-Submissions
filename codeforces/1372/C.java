import java.util.*;
import java.io.*;

public class Omkar_And_Baseball {

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
			boolean flag = true;
			int[] a = new int[n];
			int left = -1, right = n;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = 0; i < n; ++i) {
				if (a[i] != i + 1) {
					flag = false;
					break;
				}
			}

			if (flag) {
				o.println("0");
			} else {
				flag = true;

				for (int i = 0; i < n; ++i) {
					if (a[i] == i + 1) {
						left++;
					} else
						break;
				}

				for (int j = n - 1; j >= 0; --j) {
					if (a[j] == j + 1)
						right--;
					else
						break;
				}

				for (int i = left + 1; i <= right - 1; ++i) {
					if (a[i] == i + 1) {
						flag = false;
						break;
					}
				}

				if (flag)
					o.println("1");
				else
					o.println("2");
			}
		}

		o.flush();
		o.close();
	}
}