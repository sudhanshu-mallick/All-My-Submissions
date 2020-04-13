import java.util.*;
import java.io.*;

public class TL {

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
		int m = t.nextInt(), n = t.nextInt(), min = Integer.MAX_VALUE, vl = 0, max = Integer.MIN_VALUE;
		int[] g = new int[m], b = new int[n];
		boolean flag = true;

		for (int i = 0; i < m; ++i) {
			g[i] = t.nextInt();
			min = Math.min(g[i], min);
			max = Math.max(g[i], max);
		}

		vl = Math.max(max, 2 * min);

		for (int i = 0; i < n; ++i) {
			b[i] = t.nextInt();

			if (b[i] <= vl)
				flag = false;
		}

		if (flag)
			o.println(vl);
		else
			o.println(-1);

		o.flush();
		o.close();
	}
}