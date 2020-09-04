import java.util.*;
import java.io.*;

public class Rumor {

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
		int n = t.nextInt();
		int m = t.nextInt();
		long[] cost = new long[n];
		ArrayList<Integer>[] graph = new ArrayList[n];
		long ans = 0;
		boolean vis[] = new boolean[n];

		for (int i = 0; i < n; ++i) {
			cost[i] = t.nextLong();
			graph[i] = new ArrayList<>();

			graph[i].add(i);
		}

		for (int i = 0; i < m; ++i) {
			int x = t.nextInt() - 1;
			int y = t.nextInt() - 1;

			graph[y].add(x);
			graph[x].add(y);
		}

		for (int i = 0; i < n; ++i) {
			if (vis[i])
				continue;

			Stack<Integer> stack = new Stack<>();
			List<Integer> now = new ArrayList<>();

			stack.push(i);

			while (!stack.isEmpty()) {
				int v = stack.pop();
				vis[v] = true;

				now.add(v);

				for (int j = 0; j < graph[v].size(); ++j) {
					if (!vis[graph[v].get(j)])
						stack.push(graph[v].get(j));
				}
			}

			long min = Integer.MAX_VALUE;
			int idx = -1;

			for (int el : now) {
				if (min >= cost[el]) {
					min = cost[el];
					idx = el;
				}
			}

			ans += cost[idx];
		}

		o.println(ans);
		o.flush();
		o.close();
	}
}