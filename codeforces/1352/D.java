import java.util.*;
import java.io.*;

public class Alice_Bob_And_Candies {
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
		int[] a = new int[1000];

		while (test-- > 0) {
			int n = t.nextInt();

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			int i = 1, j = n - 1, count = 1;
			int ac = a[0], bc = 0, al = a[0], bo = 0;
			boolean f = true;

			while (i <= j) {
				if (f) {
					while (j >= i) {
						if (bc <= ac) {
							bo += a[j];
							bc += a[j];
							j--;
						} else
							break;
					}

					f = false;
					ac = 0;
				} else {
					while (i <= j) {
						if (bc >= ac) {
							al += a[i];
							ac += a[i];
							i++;
						} else
							break;
					}

					f = true;
					bc = 0;
				}

				count++;
			}

//			if (f && j >= i) {
//				while (j >= i)
//					bo += a[j--];
//
//				count++;
//			}
//
//			if (!f && i <= j) {
//				while (i <= j)
//					al += a[i++];
//
//				count++;
//			}

			o.println(count + " " + al + " " + bo);
		}

		o.flush();
		o.close();
	}
}