import java.util.*;
import java.io.*;

public class Kind_Anton {

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
			int[] b = new int[n];
			boolean flag = true;
			int on = 0, mo = 0, z = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();

				if (a[i] == 1)
					on++;
				else if (a[i] == -1)
					mo++;
				else
					z++;
			}

			for (int i = 0; i < n; ++i)
				b[i] = t.nextInt();

			for (int i = n - 1; i >= 0; i--) {
				if (a[i] == 0) {
					z--;

					if (b[i] > 0 && on <= 0) {
						flag = false;
						break;
					} else if (b[i] < 0 && mo <= 0) {
						flag = false;
						break;
					}

				} else if (a[i] == -1) {
					mo--;

					if (b[i] >= 0 && on <= 0) {
						flag = false;
						break;
					} else if (b[i] < -1 && mo <= 0) {
						flag = false;
						break;
					}
				} else {
					on--;

					if (b[i] > 1 && on <= 0) {
						flag = false;
						break;
					} else if (b[i] < 1 && mo <= 0) {
						flag = false;
						break;
					}

				}
			}

			if (flag)
				o.println("YES");
			else
				o.println("NO");

		}

		o.flush();
		o.close();
	}
}