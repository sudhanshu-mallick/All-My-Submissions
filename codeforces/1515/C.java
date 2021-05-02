import java.util.*;
import java.io.*;

public class Phoenix_And_Towers {

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
			int x = t.nextInt();
			int[][] a = new int[n][2];
			int[] ans = new int[n];
			PriorityQueue<int[]> pq = new PriorityQueue<>((xx, yy) -> xx[0] - yy[0]);
			int idx = n - 1;

			while (m-- > 0)
				pq.add(new int[] { 0, m + 1 });

			for (int i = 0; i < n; ++i) {
				a[i][0] = t.nextInt();
				a[i][1] = i;
			}

			Arrays.sort(a, (xx, yy) -> xx[0] - yy[0]);

			while (idx >= 0) {
				int[] val = pq.remove();
				val[0] += a[idx][0];
				ans[a[idx][1]] = val[1];
				--idx;

				pq.add(val);
			}

			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

			while (!pq.isEmpty()) {
				int[] val = pq.remove();
				min = Math.min(min, val[0]);
				max = Math.max(max, val[0]);
			}

			if (max - min > x)
				o.println("NO");
			else {
				o.println("YES");

				for (int v : ans)
					o.print(v + " ");

				o.println();
			}

		}

		o.flush();
		o.close();
	}
}