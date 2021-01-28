import java.util.*;
import java.io.*;

public class Cut_Em_All {

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
		int n = t.nextInt();
		List<Integer>[] graph = new ArrayList[n];

		for (int i = 0; i < n; ++i)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; ++i) {
			int u = t.nextInt() - 1;
			int v = t.nextInt() - 1;

			graph[u].add(v);
			graph[v].add(u);
		}

		if ((n & 1) == 1) {
			o.println("-1");
			o.flush();
			o.close();
			return;
		}

		boolean[] vis = new boolean[n];
		int[] count = new int[n];
		vis[0] = true;
		int ans = 0;

		dfs(graph, 0, count, vis);

		for (int v : count) {
			if ((v & 1) == 0)
				++ans;
		}

		o.println(ans - 1);

		o.flush();
		o.close();
	}

	private static void dfs(List<Integer> graph[], int v, int[] count, boolean[] vis) {
		count[v] = 1;

		for (int u : graph[v]) {
			if (!vis[u]) {
				vis[u] = true;

				dfs(graph, u, count, vis);

				count[v] += count[u];
			}
		}
	}
}