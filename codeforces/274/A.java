import java.util.*;
import java.io.*;

public class K_Multiple_Free_Set {

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
		int n = t.nextInt();
		long k = t.nextLong();
		HashSet<Long> map = new HashSet<>();
		Long[] a = new Long[n];
		long count = 0;

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextLong();
			map.add(a[i]);
		}

		Arrays.sort(a);

		for (int i = 0; i < n; ++i) {
			if (map.contains(a[i])) {
				Set<Long> m = new HashSet<>();
				long cur = a[i];
				m.add(a[i]);

				while (true) {
					if (map.contains(cur * k)) {
						m.add(cur * k);
						map.remove(cur * k);
						cur = cur * k;
					} else {
						break;
					}
				}

				count += (m.size() + 1) / 2;

				map.remove(a[i]);
			}
		}

		o.println(count);

		o.flush();
		o.close();
	}
}