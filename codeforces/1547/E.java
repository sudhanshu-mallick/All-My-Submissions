import java.util.*;
import java.io.*;

public class Air_Conditioners {

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
			int k = t.nextInt();
			int[] idx = new int[k];
			long[] temp = new long[k];
			boolean[] vis = new boolean[n];
			long[] ans = new long[n];

			Arrays.fill(ans, Long.MAX_VALUE);

			for (int i = 0; i < k; ++i)
				idx[i] = t.nextInt() - 1;

			for (int i = 0; i < k; ++i)
				temp[i] = t.nextLong();

			PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.temp, y.temp));

			for (int i = 0; i < k; ++i) {
				pq.add(new Pair(idx[i], temp[i]));
			}

			while (!pq.isEmpty()) {
				Pair p = pq.remove();
				ans[p.idx] = Math.min(p.temp, ans[p.idx]);
				vis[p.idx] = true;

				if (p.idx - 1 >= 0 && !vis[p.idx - 1]) {
					pq.add(new Pair(p.idx - 1, p.temp + 1));

					vis[p.idx - 1] = true;
				}

				if (p.idx + 1 < n && !vis[p.idx + 1]) {
					pq.add(new Pair(p.idx + 1, p.temp + 1));

					vis[p.idx + 1] = true;
				}
			}

			for (long v : ans)
				o.print(v + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}

class Pair {
	int idx;
	long temp;

	Pair(int idx, long temp) {
		this.idx = idx;
		this.temp = temp;
	}
}