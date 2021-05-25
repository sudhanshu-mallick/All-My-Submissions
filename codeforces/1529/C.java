import java.util.*;
import java.io.*;

public class Parsas_Humongous_Tree {

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
			long[][] cost = new long[n][2];
			List<Integer>[] graph = new ArrayList[n];
			dp = new long[n][2];

			for (int i = 0; i < n; ++i) {
				cost[i][0] = t.nextLong();
				cost[i][1] = t.nextLong();
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < n - 1; ++i) {
				int x = t.nextInt() - 1;
				int y = t.nextInt() - 1;

				graph[x].add(y);
				graph[y].add(x);
			}

			o.println(Math.max(dfs(graph, cost, 0, 0, -1), dfs(graph, cost, 0, 1, -1)));
		}

		o.flush();
		o.close();
	}

	private static long[][] dp;

	private static long dfs(List<Integer>[] graph, long[][] cost, int u, int j, int par) {
		if (dp[u][j] != 0)
			return dp[u][j];

		for (int v : graph[u])
			if (v != par) {
				long c1 = Math.abs(cost[u][j] - cost[v][0]) + dfs(graph, cost, v, 0, u);
				long c2 = Math.abs(cost[u][j] - cost[v][1]) + dfs(graph, cost, v, 1, u);
				dp[u][j] += Math.max(c1, c2);
			}

		return dp[u][j];
	}
}