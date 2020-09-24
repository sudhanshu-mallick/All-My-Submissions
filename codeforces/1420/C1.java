import java.util.*;
import java.io.*;

public class Pokemon_Army {

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
			int q = t.nextInt();
			int[] a = new int[n];
			long max = 0;
			long ans = 0;
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();
				max = a[i] < max ? max : a[i];
			}

			int i = 0;
			boolean parity = true;
			int cur = -1;

			while (i < n) {
				if (parity) {
					while (i < n && a[i] >= cur) {
						cur = a[i];
						++i;
					}
				} else {
					while (i < n && a[i] <= cur) {
						cur = a[i];
						++i;
					}
				}

				list.add(a[i - 1]);

				parity = !parity;
			}

			n = (list.size() & 1) == 0 ? list.size() - 1 : list.size();

			for (i = 0; i < n; ++i) {
				if ((i & 1) == 0)
					ans += list.get(i);
				else
					ans -= list.get(i);
			}

			o.println(ans > max ? ans : max);
		}

		o.flush();
		o.close();
	}
}