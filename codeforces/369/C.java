import java.util.*;
import java.io.*;

public class Valera_And_Elections {

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
		List<Integer> graph[] = new ArrayList[n];
		boolean[] white = new boolean[n];
		int[] count = new int[n];

		for (int i = 0; i < n; ++i)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; ++i) {
			int x = t.nextInt() - 1;
			int y = t.nextInt() - 1;
			int problem = t.nextInt();

			if (problem == 2)
				white[x] = white[y] = true;

			graph[x].add(y);
			graph[y].add(x);
		}

		countProblems(graph, 0, -1, white, count);

		int size = 0;

		for (int v : count)
			if (v == 1)
				++size;

		o.println(size);

		for (int i = 0; i < n; ++i)
			if (count[i] == 1)
				o.print(i + 1 + " ");

		o.flush();
		o.close();
	}

	private static void countProblems(List<Integer>[] graph, int cur, int prev, boolean[] white, int[] count) {
		if (white[cur])
			++count[cur];

		for (int nbr : graph[cur]) {
			if (nbr != prev) {
				countProblems(graph, nbr, cur, white, count);

				count[cur] += count[nbr];
			}
		}
	}
}
