import java.util.*;
import java.io.*;

public class Unique_Bid_Auction {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			Map<Integer, Integer> map = new HashMap<>();

			for (int i = 1; i <= n; ++i) {
				int val = t.nextInt();

				if (map.containsKey(val)) {
					map.put(val, Integer.MAX_VALUE);
				} else {
					map.put(val, i);
				}
			}

			int min = n + 1;
			int idx = -1;

			for (Map.Entry<Integer, Integer> m : map.entrySet()) {
				if (m.getValue() != Integer.MAX_VALUE) {
					if (m.getKey() < min) {
						min = m.getKey();
						idx = m.getValue();
					}
				}
			}

			o.println(idx);
		}

		o.flush();
		o.close();
	}
}