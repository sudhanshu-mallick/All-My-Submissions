
import java.util.*;
import java.io.*;

public class Book_Exchange {

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
			boolean vis[] = new boolean[n];
			int[] a = new int[n];
			int[] ans = new int[n];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt() - 1;

			for (int i = 0; i < n; ++i) {
				if (vis[i])
					continue;

				int cnt = 0;
				ArrayList<Integer> list = new ArrayList<>();
				Stack<Integer> stack = new Stack<>();

				stack.push(i);

				while (!stack.isEmpty()) {
					cnt++;
					int v = stack.pop();
					vis[v] = true;

					list.add(v);

					if (!vis[a[v]]) {
						stack.push(a[v]);
					}
				}

				for (int l : list) {
					ans[l] = cnt;
				}
			}

			for (int i : ans)
				o.print(i + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}