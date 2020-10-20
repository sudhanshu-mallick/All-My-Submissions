import java.util.*;
import java.io.*;

public class Districts_Connections {

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
			Map<Integer, Integer> map = new HashMap<>();
			int n = t.nextInt();
			List<int[]> ans = new ArrayList<>();
			int max = Integer.MIN_VALUE;
			int X = 0;

			for (int i = 0; i < n; i++) {
				int x = t.nextInt();

				map.put(x, map.getOrDefault(x, 0) + 1);
				ans.add(new int[] { x, i + 1 });

				max = Math.max(max, map.get(x));
			}

			if (max == n) {
				o.println("NO");
			} else {
				Collections.sort(ans, (x, y) -> x[0] - y[0] == 0 ? x[1] - y[1] : x[0] - y[0]);

				o.println("YES");

				for (int i = n - 1; i >= 0; i--) {
					if (ans.get(i)[0] == ans.get(0)[0]) {
						X = i;
						break;
					}

					o.println(ans.get(0)[1] + " " + ans.get(i)[1]);
				}

				for (int i = 1; i <= X; i++) {
					o.println(ans.get(i)[1] + " " + ans.get(n - 1)[1]);
				}
			}
		}

		o.flush();
		o.close();
	}

	static class Pair {
		int val;
		Stack<Integer> list;

		Pair(int val, Stack<Integer> list) {
			this.val = val;
			this.list = list;
		}
	}
}