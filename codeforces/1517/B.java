import java.util.*;
import java.io.*;

public class Morning_Jogging {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int m = t.nextInt();
			int[][] ans = new int[n][m];
			int[] idx = new int[n];
			PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
			int now = 0;

			for (int i = 0; i < n; ++i)
				for (int j = 0; j < m; ++j)
					pq.add(new int[] { t.nextInt(), i });

			while (now < m) {
				int[] a = pq.remove();
				ans[a[1]][now++] = a[0];
			}

			while (!pq.isEmpty()) {
				int[] a = pq.remove();

				while (ans[a[1]][idx[a[1]]] != 0)
					++idx[a[1]];

				ans[a[1]][idx[a[1]]] = a[0];
			}

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j)
					o.print(ans[i][j] + " ");

				o.println();
			}
		}

		o.flush();
		o.close();
	}
}