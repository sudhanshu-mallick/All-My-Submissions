import java.util.*;
import java.io.*;

public class Berpizza {

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
		int q = t.nextInt();
		int cur = 1;
		Set<Integer> set = new HashSet<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>(
				(Pair x, Pair y) -> x.value != y.value ? y.value - x.value : x.idx - y.idx);
		int q3 = 1;

		while (q-- > 0) {
			int n = t.nextInt();

			if (n == 1) {
				int val = t.nextInt();

				set.add(cur);
				pq.add(new Pair(cur, val));

				++cur;
			} else if (n == 2) {
				while (!set.contains(q3))
					++q3;

				set.remove(q3);

				o.print(q3 + " ");

			} else {
				while (!set.contains(pq.peek().idx))
					pq.remove();

				Pair p = pq.remove();

				set.remove(p.idx);

				o.print(p.idx + " ");
			}
		}

		o.flush();
		o.close();
	}

	private static class Pair {
		int idx;
		int value;

		Pair(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
	}
}