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
			int min = a[0];

			for (int i = 1; i < n; ++i) {
				min = a[i] > min ? min : a[i];
				max = a[i] > max ? a[i] : max;
			}

			if (min != max) {
				int idx = 1;

				if (a[0] == max && a[0] > a[1])
					o.println("1");
				else if (a[n - 1] == max && a[n - 1] > a[n - 2])
					o.println(n);
				else {
					while (idx < n - 1) {
						if (a[idx] == max && (a[idx] > a[idx - 1] || a[idx] > a[idx + 1]))
							break;

						++idx;
					}

					o.println(idx + 1);
				}
			} else {
				o.println("-1");
			}

		}

		o.flush();
		o.close();
	}
}