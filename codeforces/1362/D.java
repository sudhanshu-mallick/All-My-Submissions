import java.util.*;
import java.io.*;

public class Johnny_And_Contribution {

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
		ArrayList<Integer>[] a = new ArrayList[n];
		List<Integer> ans = new ArrayList<>();
		boolean flag = true;

		for (int i = 0; i < n; ++i)
			a[i] = new ArrayList<>();

		for (int i = 0; i < m; ++i) {
			int x = t.nextInt();
			int y = t.nextInt();

			a[x - 1].add(y);
			a[y - 1].add(x);
		}

		List<Integer>[] color = new ArrayList[n + 1];
		int[] blog = new int[n + 1];

		for (int i = 0; i <= n; ++i)
			color[i] = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			blog[i + 1] = t.nextInt();

			color[blog[i + 1]].add(i + 1);
		}

		for (int i = 1; i <= n; ++i) {
			for (int node : color[i]) {
				Set<Integer> set = new HashSet<>();

				for (int nbrs : a[node - 1]) {
					if (blog[nbrs] < blog[node])
						set.add(blog[nbrs]);
					else if (blog[nbrs] == blog[node]) {
						flag = false;
						break;
					}
				}

				if (set.size() != blog[node] - 1) {
					flag = false;
					break;
				}

				ans.add(node);
			}
		}

		if (flag) {
			for (int i = 0; i < ans.size(); ++i)
				o.print(ans.get(i) + " ");

			o.print("\n");
		} else
			o.println("-1");

		o.flush();
		o.close();
	}
}