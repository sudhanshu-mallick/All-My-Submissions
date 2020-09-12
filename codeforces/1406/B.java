
import java.util.*;
import java.io.*;

public class Maximum_Product {

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
			long[] a = new long[n];
			List<Long> neg = new ArrayList<>();
			List<Long> pos = new ArrayList<>();

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong();
			}

			Arrays.sort(a);

			for (int i = 0; i < n; ++i) {
				if (a[i] < 0) {
					neg.add(a[i]);
				} else if (a[i] > 0) {
					pos.add(a[i]);
				}
			}

			long max = Long.MIN_VALUE;

			if (pos.size() + neg.size() < n) {
				max = 0;
			}

			long c1 = Long.MIN_VALUE;
			long c2 = c1;
			long c3 = c1;
			long c4 = c1;
			long c5 = c1;
			long c6 = c1;

			if (pos.size() >= 5) {
				int x = pos.size();
				c1 = pos.get(x - 5) * pos.get(x - 4) * pos.get(x - 3) * pos.get(x - 2) * pos.get(x - 1);
			}

			if (pos.size() >= 4 && neg.size() >= 1) {
				int x = neg.size();
				c5 = pos.get(0) * pos.get(1) * pos.get(2) * pos.get(3) * neg.get(x - 1);
			}

			if (pos.size() >= 3 && neg.size() >= 2) {
				int x = pos.size();
				c2 = pos.get(x - 1) * pos.get(x - 2) * pos.get(x - 3) * neg.get(0) * neg.get(1);
			}

			if (pos.size() >= 2 && neg.size() >= 3) {
				int x = neg.size();
				c6 = pos.get(0) * pos.get(1) * neg.get(x - 1) * neg.get(x - 2) * neg.get(x - 3);
			}

			if (pos.size() >= 1 && neg.size() >= 4) {
				c3 = pos.get(pos.size() - 1) * neg.get(0) * neg.get(1) * neg.get(2) * neg.get(3);
			}

			if (neg.size() >= 5) {
				int x = neg.size();
				c4 = neg.get(x - 5) * neg.get(x - 4) * neg.get(x - 3) * neg.get(x - 2) * neg.get(x - 1);
			}

			max = Math.max(c1, Math.max(c2, Math.max(c3, Math.max(c4, Math.max(c5, Math.max(c6, max))))));

			o.println(max);

		}

		o.flush();
		o.close();
	}
}