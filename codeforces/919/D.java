import java.util.*;
import java.io.*;

public class Substring {

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
		int m = t.nextInt();
		String colors = t.next();
		int[][] edges = new int[m][2];

		for (int i = 0; i < m; ++i) {
			edges[i][0] = t.nextInt() - 1;
			edges[i][1] = t.nextInt() - 1;
		}

		o.println(largestPathValue(colors, edges));
		o.flush();
		o.close();
	}

	private static int largestPathValue(String colors, int[][] edges) {
		int n = colors.length();
		List<Integer>[] graph = new ArrayList[n];
		int[] inDegree = new int[n];
		Queue<Integer> queue = new LinkedList<>();
		int loopsDone = 0;
		int[][] maxColor = new int[n][26];
		int max = 0;

		for (int i = 0; i < n; ++i)
			graph[i] = new ArrayList<>();

		for (int[] a : edges) {
			int x = a[0];
			int y = a[1];
			++inDegree[y];

			graph[x].add(y);
		}

		for (int i = 0; i < n; ++i)
			if (inDegree[i] == 0)
				queue.add(i);

		while (!queue.isEmpty()) {
			++loopsDone;
			int idx = queue.remove();

			if (loopsDone >= n && !queue.isEmpty())
				return -1;

			++maxColor[idx][colors.charAt(idx) - 'a'];

			for (int val : graph[idx]) {
				--inDegree[val];

				if (inDegree[val] == 0)
					queue.add(val);

				for (int i = 0; i < 26; ++i)
					maxColor[val][i] = Math.max(maxColor[val][i], maxColor[idx][i]);
			}
		}

		if (loopsDone < n)
			return -1;

		for (int i = 0; i < n; ++i)
			for (int j = 0; j < 26; ++j)
				max = Math.max(max, maxColor[i][j]);

		return max;
	}
}