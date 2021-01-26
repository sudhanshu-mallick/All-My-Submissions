import java.util.*;
import java.io.*;

public class Strange_Beauty {

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
		int test = t.nextInt();
		List<Integer> list[] = new ArrayList[200000 + 1];

		for (int i = 0; i < list.length; ++i)
			list[i] = new ArrayList<>();

		for (int i = 1; i < list.length; ++i) {
			for (int j = 2 * i; j < list.length; j += i) {
				list[j].add(i);
			}
		}

		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[list.length];
			int[] dp = new int[list.length];
			int max = 0;

			for (int i = 0; i < n; ++i)
				++a[t.nextInt()];

			for (int i = 1; i < list.length; ++i) {
				if (a[i] == 0)
					continue;

				dp[i] = a[i];

				for (int v : list[i]) {
					dp[i] = Math.max(dp[i], dp[v] + a[i]);
				}
			}

			for (int i = 0; i < list.length; ++i)
				max = Math.max(max, dp[i]);

			o.println(n - max);
		}

		o.flush();
		o.close();
	}
}