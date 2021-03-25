import java.util.*;
import java.io.*;

public class Restoring_The_Permutation {

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
			int[] a = new int[n];
			int[] small = new int[n];
			int[] big = new int[n];
			List<int[]> step = new ArrayList<>();
			int cur = 0;
			boolean[] s1 = new boolean[n + 1];
			boolean[] s2 = new boolean[n + 1];
			PriorityQueue<Integer> p1 = new PriorityQueue<>((x, y) -> x - y);
			PriorityQueue<Integer> p2 = new PriorityQueue<>((x, y) -> y - x);

			step.add(new int[] { -1, 0 });

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = 0; i < n; ++i)
				if (a[i] > cur) {
					small[i] = big[i] = cur = a[i];
					s1[cur] = s2[cur] = true;

					step.add(new int[] { i, cur });
				}

			step.add(new int[] { n, n + 1 });

			for (int i = 2; i < step.size(); ++i) {
				int[] low = step.get(i - 2);
				int[] high = step.get(i - 1);
				int[] then = step.get(i);
				++high[0];
				int h1 = high[1] - 1;

				while (h1 > low[1]) {
					if (!s1[h1]) {
						p1.add(h1);

						s1[h1] = true;
					}

					if (!s2[h1]) {
						p2.add(h1);

						s2[h1] = true;
					}

					--h1;
				}

				while (high[0] < then[0]) {
					int v1 = p1.remove();
					int v2 = p2.remove();
					small[high[0]] = v1;
					big[high[0]] = v2;

					++high[0];
				}
			}

			for (int v : small)
				o.print(v + " ");

			o.println();

			for (int v : big)
				o.print(v + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}