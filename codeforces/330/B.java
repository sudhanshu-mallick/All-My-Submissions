import java.util.*;
import java.io.*;

public class Road_Construction {

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
		boolean[] vis = new boolean[n];

		while (m-- > 0) {
			int x = t.nextInt() - 1;
			int y = t.nextInt() - 1;
			vis[x] = vis[y] = true;
		}

		o.println(n - 1);

		int idx = 0;

		for (int i = 0; i < n; ++i) {
			if (!vis[i]) {
				idx = i;
				break;
			}
		}

		for (int i = 0; i < n; ++i) {
			if (i != idx) {
				o.println(idx + 1 + " " + (i + 1));
			}
		}

		o.flush();
		o.close();
	}
}