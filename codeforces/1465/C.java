import java.util.*;
import java.io.*;

public class Peaceful_Rooks {

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
			int m = t.nextInt();
			List<Integer> graph[] = new ArrayList[n];
			int ans = 0;
			boolean[] stack = new boolean[n];
			boolean[] vis = new boolean[n];

			for (int i = 0; i < n; ++i)
				graph[i] = new ArrayList<>();

			for (int i = 0; i < m; ++i) {
				int x = t.nextInt() - 1;
				int y = t.nextInt() - 1;

				if (x != y) {
					++ans;

					graph[x].add(y);
				}
			}

			for (int i = 0; i < n; ++i) {
				if (!vis[i] && dfs(graph, i, vis, stack)) {
					++ans;
				}
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}

	public static boolean dfs(List<Integer>[] graph, int u, boolean[] vis, boolean[] stack) {
		vis[u] = stack[u] = true;

		if (graph[u].size() > 0) {
			for (int v : graph[u]) {
				if (!vis[v] && dfs(graph, v, vis, stack))
					return true;
				else if (stack[v])
					return true;
			}
		}

		stack[u] = false;
		return false;
	}
}