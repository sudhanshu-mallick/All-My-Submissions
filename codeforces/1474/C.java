import java.util.*;
import java.io.*;

public class Array_Destruction {

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

		while (test-- > 0) {
			int n = t.nextInt() * 2;
			int[] a = new int[n];
			boolean res = false;
			int reqIdx = -1;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			shuffle(a);
			Arrays.sort(a);

			for (int i = 0; i < n - 1; ++i) {
				Map<Integer, Stack<Integer>> map = new HashMap<>();

				for (int j = 0; j < n - 1; ++j) {
					if (j == i)
						continue;

					Stack<Integer> stack = map.getOrDefault(a[j], new Stack<>());

					stack.push(j);
					map.put(a[j], stack);
				}

				int j = n - 2;
				int curMax = a[n - 1];
				boolean vis[] = new boolean[n];

				while (j >= 0) {
					if (vis[j] || j == i) {
						--j;
						continue;
					}

					int v1 = a[j];
					Stack<Integer> stack = map.get(v1);
					vis[j] = true;

					stack.pop();

					if (stack.isEmpty())
						map.remove(v1);
					else
						map.put(v1, stack);

					if (map.containsKey(curMax - v1)) {
						stack = map.get(curMax - v1);
						vis[stack.peek()] = true;

						stack.pop();

						if (stack.isEmpty())
							map.remove(curMax - v1);
						else
							map.put(curMax - v1, stack);

						curMax = v1;
					} else {
						break;
					}

					--j;
				}

				if (j == -1) {
					res = true;
					reqIdx = i;
					break;
				}
			}

			if (!res)
				o.println("NO");
			else {
				o.println("YES");
				o.println(a[n - 1] + a[reqIdx]);
				Map<Integer, Stack<Integer>> map = new HashMap<>();

				for (int j = 0; j < n - 1; ++j) {
					if (j == reqIdx)
						continue;

					Stack<Integer> stack = map.getOrDefault(a[j], new Stack<>());

					stack.push(j);
					map.put(a[j], stack);
				}

				int j = n - 2;
				int curMax = a[n - 1];
				boolean vis[] = new boolean[n];

				o.println(a[n - 1] + " " + a[reqIdx]);

				while (j >= 0) {
					if (vis[j] || j == reqIdx) {
						--j;
						continue;
					}

					int v1 = a[j];
					int v2 = curMax - v1;
					Stack<Integer> stack = map.get(v1);
					vis[j] = true;

					stack.pop();

					if (stack.isEmpty())
						map.remove(v1);

					stack = map.get(curMax - v1);
					vis[stack.peek()] = true;

					stack.pop();

					if (stack.isEmpty())
						map.remove(curMax - v1);

					--j;
					curMax = v1;

					o.println(v1 + " " + v2);
				}

			}
		}

		o.flush();
		o.close();
	}
}
