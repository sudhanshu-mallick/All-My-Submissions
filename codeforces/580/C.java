import java.io.*;
import java.util.*;

public class Kefa_And_Park {

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
		a = new ArrayList[n];
		int k = t.nextInt();
		cat = new int[n];
		ans = 0;

		for (int i = 0; i < n; ++i)
			cat[i] = t.nextInt();

		for (int i = 0; i < n; ++i)
			a[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; ++i) {
			int x = t.nextInt() - 1;
			int y = t.nextInt() - 1;
			a[x].add(y);
			a[y].add(x);
		}

		dfs(0, 0, new boolean[n], k);

		o.println(ans);
		o.flush();
		o.close();
	}

	private static int ans;
	private static int[] cat;
	private static List<Integer>[] a;

	public static void dfs(int s, int cur, boolean[] v, int k) {
		v[s] = true;

		if (cur > k)
			return;

		if (cat[s] == 1)
			cur++;
		else
			cur = 0;

		if (cur > k)
			return;

		if (s != 0 && a[s].size() == 1) {
			ans++;
			return;
		}

		for (int x : a[s]) {
			if (!v[x])
				dfs(x, cur, v, k);
		}
	}
}