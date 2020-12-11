import java.util.*;
import java.io.*;

public class Orac_And_LCM {

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
		long[] a = new long[n];
		Map<Long, List<Long>> map = new HashMap<>();

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		for (int i = 0; i < n; ++i) {
			long val = a[i];

			if ((val & 1) == 0) {
				long cnt = 0;

				while ((val & 1) == 0) {
					++cnt;
					val = val >> 1;
				}

				List<Long> list = map.getOrDefault(2l, new ArrayList<>());

				list.add(cnt);
				map.put(2l, list);
			}

			for (long j = 3; j * j <= val; ++j) {
				if (val % j == 0) {
					long cnt = 0;

					while (val % j == 0) {
						++cnt;
						val /= j;
					}

					List<Long> list = map.getOrDefault(j, new ArrayList<>());

					list.add(cnt);
					map.put(j, list);
				}
			}

			if (val > 1) {
				List<Long> list = map.getOrDefault(val, new ArrayList<>());

				list.add(1l);
				map.put(val, list);
			}
		}

		int ans = 1;

		if (n == 2) {
			long gcd = gcd(a[0], a[1]);

			o.println((a[0] * a[1]) / gcd);
		} else {

			for (Map.Entry<Long, List<Long>> m : map.entrySet()) {
				if (m.getValue().size() < n - 1)
					continue;

				List<Long> list = m.getValue();

				Collections.sort(list);

				long val = m.getKey(), pow = 1l;

				if (list.size() == n - 1) {
					pow = list.get(0);
				} else {
					pow = list.get(1);
				}

				while (pow-- > 0) {
					ans *= val;
				}
			}

			o.println(ans);
		}
		o.flush();
		o.close();
	}

	public static long gcd(long x, long y) {
		if (x == 0)
			return y;

		return gcd(y % x, x);
	}
}