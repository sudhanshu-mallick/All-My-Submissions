import java.util.*;
import java.io.*;

public class Verse_For_Santa {

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
		int[] a = new int[(int) 1e5];

		while (test-- > 0) {
			int n = t.nextInt();
			int s = t.nextInt();
			int max = 0, idx = 0, sum = 0, c1 = 0, c2 = 0;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = 0; i < n; ++i) {

				if (sum + a[i] > s) {
					if (max < a[i]) {
						max = a[i];
						idx = i;
					}

					break;
				}

				sum += a[i];

				if (max < a[i]) {
					max = a[i];
					idx = i;
				}

				c1++;
			}

			sum = 0;

			for (int i = 0; i < n; ++i) {
				if (i == idx)
					continue;

				if (sum + a[i] > s)
					break;

				c2++;
				sum += a[i];
			}

			if (c2 >= c1)
				o.println(idx + 1);
			else
				o.println(0);

		}

		o.flush();
		o.close();
	}
}