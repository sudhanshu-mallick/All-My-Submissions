import java.util.*;
import java.io.*;

public class Dijkstra {

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

	static class Edge {
		int vt1;
		int nbr;
		int weight;

		Edge(int vt1, int nbr, int weight) {
			this.vt1 = vt1;
			this.nbr = nbr;
			this.weight = weight;
		}
	}

	static class Pair {
		int v;
		int wsf;

		Pair(int v, int wsf) {
			this.v = v;
			this.wsf = wsf;
		}
	}

	public static void main(String[] args) {
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int vtces = t.nextInt();
		int m = t.nextInt();
		int[] dist = new int[vtces];
		List<Edge>[] graph = new ArrayList[vtces];
		boolean flag = false;
		int[][] from = new int[vtces][2];

		for (int i = 0; i < vtces; ++i) {
			graph[i] = new ArrayList<>();
		}

		Arrays.fill(dist, -1);

		for (int i = 0; i < vtces; ++i)
			from[i][1] = Integer.MAX_VALUE;

		for (int i = 0; i < m; ++i) {
			int v1 = t.nextInt() - 1;
			int v2 = t.nextInt() - 1;
			int wt = t.nextInt();

			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}

		int source = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>((Pair x, Pair y) -> x.wsf - y.wsf);
		boolean vis[] = new boolean[vtces];
		pq.add(new Pair(0, 0));

		while (pq.size() > 0) {
			Pair cur = pq.remove();

			if (vis[cur.v]) {
				continue;
			}

			vis[cur.v] = true;

			if (cur.v + 1 == vtces) {
				flag = true;
				break;
			}

			for (Edge e : graph[cur.v]) {
				if (!vis[e.nbr]) {
					if (cur.wsf + e.weight < from[e.nbr][1]) {
						from[e.nbr][0] = cur.v;
						from[e.nbr][1] = cur.wsf + e.weight;
					}

					pq.add(new Pair(e.nbr, cur.wsf + e.weight));
				}
			}
		}

		if (!flag)
			o.print("-1");
		else {
			Stack<Integer> stack = new Stack<>();
			int cur = vtces - 1;

			stack.add(vtces - 1);

			while (cur != 0) {
				cur = from[cur][0];

				stack.add(cur);
			}

			while (!stack.isEmpty())
				o.print(stack.pop() + 1 + " ");
		}

		o.flush();
		o.close();
	}
}