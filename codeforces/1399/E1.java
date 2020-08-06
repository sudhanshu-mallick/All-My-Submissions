
import java.util.*;
import java.io.*;

public class Weighted_Divisions {
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
			long s = t.nextLong();
			List<Pair>[] list = new ArrayList[n];
			boolean vis[] = new boolean[n];
			Pair[] pair = new Pair[n];

			for (int i = 0; i < n; ++i)
				list[i] = new ArrayList<>();

			for (int i = 0; i < n - 1; ++i) {
				int x = t.nextInt() - 1;
				int y = t.nextInt() - 1;
				long sum = t.nextLong();

				pair[x] = new Pair();
				pair[y] = new Pair();
				list[x].add(new Pair(y, sum));
				list[y].add(new Pair(x, sum));
			}

			updateChildren(list, 0, vis, pair);

			vis = new boolean[n];
			Stack<Integer> stack = new Stack<>();
			PriorityQueue<long[]> pq = new PriorityQueue<>(
					(o1, o2) -> Long.compare((o2[0] - o2[0] / 2) * o2[1], (o1[0] - o1[0] / 2) * o1[1]));
			vis[0] = true;
			long sum = 0;

			for (int i = 0; i < list[0].size(); ++i) {
				stack.push(list[0].get(i).vtx);

				vis[list[0].get(i).vtx] = true;
				int v = list[0].get(i).vtx;
				long[] a = { list[0].get(i).s, pair[v].children };
				sum += list[0].get(i).s * pair[v].children;

				pq.add(a);
			}
//
//			for (int i = 0; i < n; ++i)
//				System.out.println(pair[i].children);

			while (stack.size() > 0) {
				int idx = stack.pop();
				vis[idx] = true;

				for (int i = 0; i < list[idx].size(); ++i) {
					int v = list[idx].get(i).vtx;

					if (!vis[v]) {
						long[] a = { list[idx].get(i).s, pair[v].children };
						sum += (list[idx].get(i).s * pair[v].children);
						stack.add(v);
						pq.add(a);
					}
				}
			}

			int count = 0;

			while (sum > s) {
				long[] a = pq.remove();
				sum -= ((a[0] + 1) / 2) * (a[1]);
				a[0] = a[0] / 2;

//				System.out.println(sum);
				count++;

				if (a[0] > 0)
					pq.add(a);
			}

			o.println(count);
		}

		o.flush();
		o.close();
	}

	private static void updateChildren(List<Pair> list[], int idx, boolean vis[], Pair[] pair) {
		if (vis[idx])
			return;

		vis[idx] = true;
		int cnt = 0;

		for (int i = 0; i < list[idx].size(); ++i) {
			int v = list[idx].get(i).vtx;

			if (!vis[v]) {
				updateChildren(list, list[idx].get(i).vtx, vis, pair);

				cnt += pair[v].children;
			}
		}

		if (cnt == 0)
			cnt++;

		pair[idx].children = cnt;
	}

	private static class Pair {
		int vtx;
		long s;
		int children;

		Pair(int vtx, long s) {
			this.vtx = vtx;
			this.s = s;
		}

		Pair() {
		}
	}
}