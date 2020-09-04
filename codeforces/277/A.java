import java.util.*;
import java.io.*;

public class Learning_Languages {

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
		int[][] graph = new int[m][m];
		int c1 = 0;
		boolean vis[] = new boolean[m];
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < n; ++i) {
			int size = t.nextInt();
			int[] a = new int[size];

			for (int j = 0; j < size; ++j) {
				a[j] = t.nextInt() - 1;
				graph[a[j]][a[j]] = 1;
			}

			for (int x = 0; x < size - 1; ++x) {
				graph[a[x]][a[x + 1]] = graph[a[x + 1]][a[x]] = 1;
			}

			if (size == 0)
				c1++;
		}

		int c2 = -1;

		for (int i = 0; i < m; ++i) {
			if (vis[i])
				continue;

			int size = 0;

			for (int j = 0; j < m; ++j)
				size += graph[i][j];

			if (size == 0) {
				continue;
			}

			Stack<Integer> stack = new Stack<>();

			stack.push(i);

			while (!stack.isEmpty()) {
				int cur = stack.pop();
				vis[cur] = true;

				for (int j = 0; j < m; ++j) {
					if (graph[cur][j] > 0 && !vis[j]) {
						stack.push(j);
					}
				}
			}

			c2++;
		}

		c2 = c2 == -1 ? 0 : c2;

		o.println(c1 + c2);
		o.flush();
		o.close();
	}
}