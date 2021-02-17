import java.util.*;
import java.io.*;

public class Permutation_Transformation {

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

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			Tree tree = new Tree(a);

			for (int i = 0; i < n; ++i) {
				o.print(tree.mapDepth.get(a[i]) + " ");
			}

			o.println();
		}

		o.flush();
		o.close();
	}

}

class Tree {
	Map<Integer, Integer> mapDepth;

	Tree(int[] a) {
		int n = a.length;
		int l = 0, r = n - 1;
		int mid = -1;
		mapDepth = new HashMap<>();

		for (int i = 0; i < n; ++i) {
			if (a[i] == n) {
				mid = i;
				break;
			}
		}

		mapDepth.put(a[mid], 0);
		construct(a, l, mid - 1, 1);
		construct(a, mid + 1, r, 1);
	}

	void construct(int[] a, int l, int r, int level) {
		if (l > r)
			return;

		int mid = -1;
		int max = 0;

		for (int i = l; i <= r; ++i) {
			if (a[i] > max) {
				max = a[i];
				mid = i;
			}
		}

		mapDepth.put(max, level);
		construct(a, l, mid - 1, level + 1);
		construct(a, mid + 1, r, level + 1);
	}
}