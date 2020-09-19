import java.util.*;
import java.io.*;

public class Fox_And_Two_Dots {

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
		int m = t.nextInt();
		int n = t.nextInt();
		char[][] a = new char[m][n];

		for (int i = 0; i < m; ++i) {
			String s = t.next();

			for (int j = 0; j < n; ++j)
				a[i][j] = s.charAt(j);
		}

		boolean vis[][] = new boolean[m][n];
		String ans = "No";

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (vis[i][j])
					continue;

				Set<String> set = new HashSet<>();

				if (dfs(a, a[i][j], vis, i, j, m, n, set)) {
					ans = "Yes";
					break;
				}
			}

			if (ans.equals("Yes"))
				break;
		}

		o.println(ans);
		o.flush();
		o.close();
	}

	private static boolean dfs(char[][] a, char cur, boolean vis[][], int i, int j, int m, int n, Set<String> set) {
		if (i < 0 || j < 0 || i >= m || j >= n || a[i][j] != cur)
			return false;

		if (set.contains(i + " " + j))
			return false;

		if (vis[i][j])
			return true;

		vis[i][j] = true;

		set.add(i + " " + j);

		int[] dir = { 1, 0, -1, 0, 1 };

		for (int k = 0; k < 4; ++k) {
			int x = i + dir[k];
			int y = j + dir[k + 1];

			if (dfs(a, cur, vis, x, y, m, n, set))
				return true;
		}

		set.remove(i + " " + j);

		return false;
	}
}