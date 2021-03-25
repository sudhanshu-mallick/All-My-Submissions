import java.util.*;
import java.io.*;

public class Epic_Transformations {

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
			Map<Integer, Integer> map = new HashMap<>();
			int ans = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt();

				map.put(x, map.getOrDefault(x, 0) + 1);
			}

			for (Map.Entry<Integer, Integer> m : map.entrySet()) {
				pq.add(m.getValue());
			}

			while (pq.size() > 1) {
				int v1 = pq.remove() - 1;
				int v2 = pq.remove() - 1;

				if (v1 > 0)
					pq.add(v1);

				if (v2 > 0)
					pq.add(v2);
			}

			while (!pq.isEmpty())
				ans += pq.remove();

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}