import java.util.*;
import java.io.*;

public class Chat_Onlin {

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
		int p = t.nextInt();
		int q = t.nextInt();
		int[] a = new int[2 * p];
		int[] b = new int[2 * q];
		int l = t.nextInt();
		int r = t.nextInt();

		for (int i = 0; i < 2 * p; i += 2) {
			a[i] = t.nextInt() + 1;
			a[i + 1] = t.nextInt() + 1;
		}

		for (int i = 0; i < 2 * q; i += 2) {
			b[i] = t.nextInt() + 1;
			b[i + 1] = t.nextInt() + 1;
		}

		boolean[] possible = new boolean[1002];
		int[] vis = new int[1002];

		for (int i = 0; i < 2 * p; i += 2) {
			for (int j = a[i]; j <= a[i + 1]; ++j)
				possible[j] = true;
		}

		for (int i = 1; i <= 1001; ++i) {
			if (possible[i])
				vis[i] = 1 + vis[i - 1];
			else
				vis[i] = vis[i - 1];
		}

		int count = 0;

		for (int j = l; j <= r; ++j) {
			for (int i = 0; i < 2 * q; i += 2) {
				int low = b[i] - 1 + j;
				int high = b[i + 1] + j;

				if (low <= 1001 && vis[Math.min(1001, high)] > vis[low]) {
					count++;
					break;
				}
			}
		}

		o.println(count);

		o.flush();
		o.close();
	}
}