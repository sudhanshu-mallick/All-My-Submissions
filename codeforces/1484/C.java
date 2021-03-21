import java.util.*;
import java.io.*;

public class Basic_Diplomacy {

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
			int m = t.nextInt();
			int[] count = new int[n];
			int[] ans = new int[m];
			PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.size - y.size);

			for (int i = 0; i < m; ++i) {
				int size = t.nextInt();
				int[] a = new int[size];

				for (int j = 0; j < size; ++j)
					a[j] = t.nextInt() - 1;

				pq.add(new Pair(i, a, size));
			}

			while (!pq.isEmpty()) {
				Pair p = pq.remove();
				int minIdx = 0;
				int min = Integer.MAX_VALUE;

				for (int v : p.a) {
					if (count[v] <= min) {
						minIdx = v;
						min = count[v];
					}
				}

				ans[p.idx] = minIdx;
				++count[minIdx];
			}

			Map<Integer, Integer> map = new HashMap<>();
			boolean flag = true;
			m = (m + 1) >> 1;

			for (int v : ans) {
				map.put(v, map.getOrDefault(v, 0) + 1);

				if (map.get(v) > m) {
					flag = false;
					break;
				}
			}

			if (flag) {
				o.println("YES");

				for (int v : ans)
					o.print(v + 1 + " ");

				o.println();
			} else
				o.println("NO");

		}

		o.flush();
		o.close();
	}
}

class Pair {
	int idx;
	int size;
	int[] a;

	Pair(int idx, int[] a, int size) {
		this.idx = idx;
		this.a = a;
		this.size = size;
	}
}