import java.util.*;
import java.io.*;

public class New_Year_Permutation {

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
		int n = t.nextInt();
		int[] a = new int[n];
		int[][] mat = new int[n][n];

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		for (int i = 0; i < n; ++i) {
			String s = t.next();

			for (int j = 0; j < n; ++j)
				mat[i][j] = s.charAt(j) - '0';
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (mat[i][j] == 0)
					continue;

				List<Integer> idx = new ArrayList<>();
				Stack<Integer> stack = new Stack<>();
				Set<Integer> set = new HashSet<>();

				stack.push(i);
				set.add(i);

				while (!stack.isEmpty()) {
					int v = stack.pop();

					idx.add(v);

					for (int k = 0; k < n; ++k) {
						if (mat[v][k] == 1) {
							mat[v][k] = mat[k][v] = 0;

							if (!set.contains(k)) {
								stack.push(k);
								set.add(k);
							}
						}
					}
				}

				List<Integer> ele = new ArrayList<>();

				for (int id : idx)
					ele.add(a[id]);

				Collections.sort(ele);
				Collections.sort(idx);

				int k = 0;

				for (int id : idx) {
					a[id] = ele.get(k++);
				}
			}
		}

		for (int val : a) {
			o.print(val + " ");
		}

		o.flush();
		o.close();
	}
}