import java.util.*;
import java.io.*;

public class Fence_Painting {

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
			int[] a = new int[n];
			int[] b = new int[n];
			int[] c = new int[m];
			int[] ans = new int[m];
			Map<Integer, Stack<Integer>> map = new HashMap<>();
			Map<Integer, Stack<Integer>> present = new HashMap<>();

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = 0; i < n; ++i) {
				b[i] = t.nextInt();

				if (a[i] != b[i]) {
					Stack<Integer> list = map.getOrDefault(b[i], new Stack<>());

					list.push(i);
					map.put(b[i], list);
				} else {
					Stack<Integer> list = present.getOrDefault(b[i], new Stack<>());

					list.push(i);
					present.put(b[i], list);
				}
			}

			for (int i = 0; i < m; ++i)
				c[i] = t.nextInt();

			int idx = -1;
			int i = m - 1;
			boolean flag = true;

			while (i >= 0) {
				if (map.containsKey(c[i])) {
					Stack<Integer> stack = map.get(c[i]);
					int id = stack.pop();
					idx = id;
					ans[i] = id + 1;

					if (stack.size() == 0)
						map.remove(c[i]);
				} else {
					if (idx != -1) {
						ans[i] = idx + 1;
					} else if (present.containsKey(c[i])) {
						Stack<Integer> stack = present.get(c[i]);
						int id = stack.peek();
						idx = id;
						ans[i] = id + 1;
					} else {
						flag = false;
						break;
					}
				}

				--i;
			}

			if (flag)
				for (i = 0; i < m; ++i) {
					a[ans[i] - 1] = c[i];
				}

			for (i = 0; i < n; ++i) {
				if (a[i] != b[i]) {
					flag = false;
				}
			}

			if (flag) {
				o.println("YES");

				for (int v : ans) {
					o.print(v + " ");
				}

				o.println();
			} else {
				o.println("NO");
			}

		}

		o.flush();
		o.close();
	}
}