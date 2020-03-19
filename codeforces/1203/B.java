import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Equal_Rectangles {

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
			n = 2 * n;
			Integer a[] = new Integer[2 * n];
			Integer b[] = new Integer[n];
			boolean flag = true;

			for (int i = 0; i < 2 * n; i++)
				a[i] = t.nextInt();

			Arrays.sort(a);

			for (int i = 0; i < 2 * n; i += 2) {
				if (a[i].equals(a[i + 1])) {
					b[i / 2] = a[i];
				} else {
					flag = false;
					break;
				}
			}

			if (!flag)
				o.println("NO");
			else {
				int max = b[n - 1] * b[0];

				for (int i = 0; i <= n / 2; i++) {
					int ar = b[i] * b[n - i - 1];

					if (max != ar) {
						flag = false;
						break;
					}
				}

				if (flag)
					o.println("YES");
				else
					o.println("NO");
			}

		}

		o.flush();
		o.close();
	}

}