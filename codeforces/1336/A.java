import java.util.*;
import java.io.*;

public class Linova_And_Kingdom {

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

	public static void shuffle(long[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(long[] a, int i, int j) {
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt();
		int k = t.nextInt();
		List<Integer>[] graph = new ArrayList[n];
		long[] calc = new long[n];
		long ans = 0;

		for (int i = 0; i < n; ++i)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; ++i) {
			int x = t.nextInt() - 1;
			int y = t.nextInt() - 1;

			graph[x].add(y);
			graph[y].add(x);
		}

		graph[0].add(-1);

		calc(graph, calc, 0l, 0, -1);
		shuffle(calc);

		for (int i = n - 1; i >= n - k; --i) {
			ans += calc[i];
		}

		o.println(ans);
		o.flush();
		o.close();
	}

	private static long calc(List<Integer>[] graph, long[] calc, long level, int cur, int par) {
		long count = 0;

		if (graph[cur].size() == 1) {
			calc[cur] = level;

			return 1l;
		}

		for (int nbr : graph[cur]) {
			if (nbr != par) {
				count += calc(graph, calc, level + 1, nbr, cur);
			}
		}

		calc[cur] = level - count;

		return count + 1;
	}
}