import java.util.*;
import java.io.*;

public class Checkposts {

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
		int n = t.nextInt();
		long[] cost = new long[n];
		List<Integer> graph[] = new ArrayList[n];
		List<Integer> par[] = new ArrayList[n];

		for (int i = 0; i < n; ++i) {
			cost[i] = t.nextLong();
			graph[i] = new ArrayList<>();
			par[i] = new ArrayList<>();
		}

		int m = t.nextInt();
		Stack<Integer> stack = new Stack<>();
		boolean[] vis = new boolean[n];

		while (m-- > 0) {
			int x = t.nextInt() - 1;
			int y = t.nextInt() - 1;

			graph[x].add(y);
			par[y].add(x);
		}

		for (int i = 0; i < n; ++i)
			if (!vis[i])
				dfs1(graph, vis, stack, i);

		vis = new boolean[n];
		long ans = 0, ways = 1, mod = 1_000_000_007;

		while (!stack.isEmpty()) {
			int el = stack.pop();

			if (!vis[el]) {
				List<Integer> list = new ArrayList<>();
				long min = Integer.MAX_VALUE;
				long cnt = 0;

				dfs2(el, par, list, vis);

				for (int v : list)
					min = Math.min(min, cost[v]);

				ans += min;

				for (int v : list)
					if (cost[v] == min)
						++cnt;

				ways = (ways * cnt) % mod;
			}
		}

		o.println(ans + " " + ways);
		o.flush();
		o.close();
	}

	private static void dfs1(List<Integer>[] graph, boolean[] vis, Stack<Integer> stack, int v) {
		vis[v] = true;

		for (int nbr : graph[v])
			if (!vis[nbr])
				dfs1(graph, vis, stack, nbr);

		stack.push(v);
	}

	private static void dfs2(int v, List<Integer>[] par, List<Integer> list, boolean[] vis) {
		vis[v] = true;

		list.add(v);

		for (int nbr : par[v])
			if (!vis[nbr])
				dfs2(nbr, par, list, vis);
	}
}