
import java.util.*;
import java.io.*;

public class Phonix_And_Beauty {

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
			int k = t.nextInt();
			int[] a = new int[n];
			// int sum = 0;
			// boolean f = true;
			ArrayList<Integer> l = new ArrayList<>();
			HashSet<Integer> m = new HashSet<>();

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();

				if (!m.contains(a[i])) {
					l.add(a[i]);
					m.add(a[i]);
				}
			}

			if (m.size() <= k) {
				for (int i = 1; i <= n; ++i) {

					if (m.size() == k)
						break;

					if (!m.contains(i)) {
						m.add(i);
						l.add(i);
					}
				}

				o.println(n * k);

				for (int i = 0; i < n; ++i)
					for (int j = 0; j < k; ++j)
						o.print(l.get(j) + " ");

				o.println();

			} else {
				o.println("-1");
			}

		}
		o.flush();
		o.close();

	}
}
