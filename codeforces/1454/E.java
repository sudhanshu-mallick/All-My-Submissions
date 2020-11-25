import java.util.*;
import java.io.*;

public class Number_Into_Sequence {

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
			Set<Integer>[] graph = new Set[n];
			color = new int[n];
			parent = new int[n];
			cycle_end = -1;
			cycle_start = -1;

			for (int i = 0; i < n; ++i) {
				graph[i] = new HashSet<>();
				parent[i] = -1;
			}

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt() - 1;
				int y = t.nextInt() - 1;

				graph[x].add(y);
				graph[y].add(x);
			}

			boolean[] vis = new boolean[n];
			List<Long> count = new ArrayList<>();

			find_cycle(graph);

			for (int i = 0; i < n; ++i) {
				if (!vis[i]) {
					Stack<Integer> stack = new Stack<>();
					Set<Integer> cur = new HashSet<>();
					vis[i] = true;

					stack.push(i);

					while (!stack.isEmpty()) {
						int v = stack.pop();

						cur.add(v);

						for (int val : graph[v]) {
							if (!vis[val]) {
								stack.push(val);

								vis[val] = true;
							}
						}
					}

					count.add((long) cur.size());
				}
			}

			long ans = 0;

			for (long v : count) {
				ans += (v * (v - 1)) >> 1;
				ans += (n - v) * v;
			}

			o.println(ans);

		}

		o.flush();
		o.close();
	}

	public static int color[];
	public static int parent[];
	public static int cycle_end;
	public static int cycle_start;

	private static boolean dfs(int v, int par, Set<Integer>[] graph) {
		color[v] = 1;

		for (int u : graph[v]) {
			if (u == par)
				continue;
			if (color[u] == 0) {
				parent[u] = v;

				if (dfs(u, parent[u], graph))
					return true;

			} else if (color[u] == 1) {
				cycle_end = v;
				cycle_start = u;

				return true;
			}
		}

		color[v] = 2;

		return false;
	}

	public static void find_cycle(Set<Integer>[] graph) {
		int n = graph.length;
		List<Integer> cycle = new ArrayList<>();

		for (int v = 0; v < n; v++) {
			if (color[v] == 0 && dfs(v, parent[v], graph))
				break;
		}

		cycle.add(cycle_start);

		for (int v = cycle_end; v != cycle_start; v = parent[v])
			cycle.add(v);

		cycle.add(cycle_start);

		for (int i = 0; i < cycle.size() - 1; ++i) {
			int x = cycle.get(i);
			int y = cycle.get(i + 1);

			graph[x].remove(y);
			graph[y].remove(x);
		}
	}
}