import java.util.*;
import java.io.*;

public class Card_Deck {

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

		Arrays.sort(a);
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
			int[] a = new int[n];
			Map<Integer, Integer> map = new HashMap<>();
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();
				map.put(a[i], i);
			}

			int cur = n;

			while (!map.isEmpty()) {
				int idx = map.get(cur);

				while (idx < n && map.containsKey(a[idx])) {
					list.add(a[idx]);
					map.remove(a[idx]);

					++idx;
				}

				while (cur > 0 && !map.containsKey(cur)) {
					--cur;
				}
			}

			for (int v : list)
				o.print(v + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}