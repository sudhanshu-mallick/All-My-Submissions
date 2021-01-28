import java.util.*;
import java.io.*;

public class Powers_Of_Two {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt();
		long[] a = new long[n];

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextLong();
		}

		long cur = 2;
		int i = 1;
		long count = 0;

		while (i < 32) {
			Map<Long, Long> map = new HashMap<>();

			for (long v : a) {
				if (v < cur) {
					map.put(v, map.getOrDefault(v, 0l) + 1l);
				}
			}

			for (Map.Entry<Long, Long> m : map.entrySet()) {
				if (m.getKey() < (cur >> 1)) {
					count += (m.getValue() * map.getOrDefault(cur - m.getKey(), 0l));
				} else if (m.getKey() == (cur >> 1)) {
					count += ((m.getValue() * (m.getValue() - 1)) >> 1);
				}
			}

			++i;
			cur = cur << 1;
		}

		o.println(count);
		o.flush();
		o.close();
	}
}