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

			for (int i = 0; i < n; ++i) {
				graph[i] = new HashSet<>();
			}

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt() - 1;
				int y = t.nextInt() - 1;

				graph[x].add(y);
				graph[y].add(x);
			}

			long[] count = new long[n];
			Queue<Integer> queue = new LinkedList<>();

			for (int i = 0; i < n; ++i) {
				if (graph[i].size() == 1) {

					queue.add(i);
				}

				count[i] = 1;
			}

			while (!queue.isEmpty()) {
				int from = queue.remove();
				int to = -1;

				for (int val : graph[from]) {
					to = val;
				}

				graph[from].clear();
				graph[to].remove(from);

				count[to] += count[from];
				count[from] = 0;

				if (graph[to].size() == 1)
					queue.add(to);
			}

			long ans = 0;

			for (int i = 0; i < n; ++i) {
				ans += (count[i] * (count[i] - 1)) >> 1;
				ans += (n - count[i]) * count[i];
			}

			o.println(ans);

		}

		o.flush();
		o.close();
	}
}