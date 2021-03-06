import java.util.*;
import java.io.*;

public class Dominant_Pirahana {

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

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			int max = a[0];
			int idx = 0;
			int min = a[0];

			for (int i = 1; i < n; ++i) {
				min = Math.min(min, a[i]);

				if (max < a[i]) {
					idx = i;
					max = a[i];
				}
			}

			if (min == max) {
				o.println("-1");
			} else {
				if (idx == 0) {
					while (idx < n) {
						if (a[idx] != max) {
							break;
						}

						idx++;
					}

					--idx;
				}

				o.println(idx + 1);
			}

		}

		o.flush();
		o.close();
	}
}