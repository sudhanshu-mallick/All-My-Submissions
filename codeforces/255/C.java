import java.util.*;
import java.io.*;

public class Almost_Arithmetical_Progression {

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
		int max = 0;
		int n = t.nextInt();
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < n; ++i) {
			int x = t.nextInt();
			List<Integer> list = map.getOrDefault(x, new ArrayList<>());

			list.add(i);
			map.put(x, list);
		}

		for (Map.Entry<Integer, List<Integer>> m : map.entrySet())
			max = Math.max(max, m.getValue().size());

		for (Map.Entry<Integer, List<Integer>> m1 : map.entrySet())
			for (Map.Entry<Integer, List<Integer>> m2 : map.entrySet()) {
				if (m1.getKey() == m2.getKey())
					continue;

				List<Integer> l1 = m1.getValue();
				List<Integer> l2 = m2.getValue();
				int count = 0;
				int i = 0, j = 0;
				boolean turn = false;

				if (l1.get(0) > l2.get(0)) {
					turn = true;
				}

				while (i < l1.size() && j < l2.size()) {
					if (turn) {
						if (l2.get(j) < l1.get(i)) {
							turn = !turn;
							++count;
							++j;
						} else
							++i;
					} else {
						if (l1.get(i) < l2.get(j)) {
							turn = !turn;
							++count;
							++i;
						} else
							++j;
					}
				}

				while (turn && j < l2.size()) {
					if (l2.get(j) > l1.get(l1.size() - 1)) {
						++count;
						turn = false;
					}

					++j;
				}

				while (!turn && i < l1.size()) {
					if (l1.get(i) > l2.get(l2.size() - 1)) {
						++count;
						turn = true;
					}

					++i;
				}

				max = Math.max(max, count);
			}

		o.println(max);
		o.flush();
		o.close();
	}
}