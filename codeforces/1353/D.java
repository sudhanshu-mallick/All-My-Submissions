import java.util.Queue;
import java.util.*;
import java.io.*;

public class Constructing_The_Array {

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
		// PrintWriter o = new PrintWriter(System.out);
		Constructing_The_Array obj = new Constructing_The_Array();

		obj.solve();

//		o.flush();
//		o.close();
	}

	class PAIR implements Comparable<PAIR> {
		int l;
		int r;
		int size;

		PAIR(int l, int r) {
			this.l = l;
			this.r = r;
			this.size = r - l + 1;
		}

		public int compareTo(PAIR o) {
			return o.size - this.size != 0 ? o.size - this.size : this.l - o.l;
		}
	}

	public void solve() {
		FastReader t = new FastReader();
		// PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int num = 1;
			Queue<PAIR> queue = new PriorityQueue<>();
			int[] a = new int[n + 1];
			// System.out.println(n);

			queue.add(new PAIR(1, n));

			while (!queue.isEmpty()) {
				PAIR p = queue.remove();
				int l = p.l;
				int r = p.r;
				int mid = (r + l) / 2;

				if (l > r)
					continue;

				a[(r + l) / 2] = num++;

				if (((r - l + 1) & 1) == 1) {
					queue.add(new PAIR(l, mid - 1));
					queue.add(new PAIR(mid + 1, r));
				} else {
					queue.add(new PAIR(mid + 1, r));
					queue.add(new PAIR(l, mid - 1));
				}
			}

			for (int i = 1; i <= n; ++i)
				System.out.print(a[i] + " ");

			System.out.println();
		}

//		o.flush();
//		o.close();
	}
}