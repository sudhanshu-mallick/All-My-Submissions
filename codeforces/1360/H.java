import java.util.*;
import java.io.*;

public class Binary_Median {

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
			int m = t.nextInt();
			int n = t.nextInt();
			long[] a = new long[m];
			HashSet<Long> set = new HashSet<>();
			long median = (1l << (n - 1)) - 1;
			long len = (1l << n);

			for (int i = 0; i < m; ++i) {
				String s = t.next();
				long val = Long.valueOf(s, 2);
				a[i] = val;
			}

			for (int i = 0; i < m; ++i) {
				long val = a[i];

				if (a[i] == median) {
					if ((len & 1) == 0) {
						median++;

						while (set.contains(median))
							median++;
					} else {
						median--;

						while (set.contains(median))
							median--;
					}
				} else if (a[i] > median) {
					if ((len & 1) == 1) {
						median--;

						while (set.contains(median))
							median--;
					}
				} else {
					if ((len & 1) == 0) {
						median++;

						while (set.contains(median))
							median++;
					}
				}

				len--;
				set.add(val);
			}

			String s = Long.toBinaryString(median);
			len = n - s.length();

			while (len-- > 0)
				o.print("0");

			o.println(s);

		}

		o.flush();
		o.close();
	}
}
