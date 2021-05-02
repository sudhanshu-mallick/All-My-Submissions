import java.util.*;
import java.io.*;

public class Phoenix_And_Gold {

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
			int x = t.nextInt();
			int[] w = new int[n];

			for (int i = 0; i < n; ++i)
				w[i] = t.nextInt();

			if (n == 1) {
				if (x == w[0])
					o.println("NO");
				else
					o.println("YES\n" + w[0]);
			} else {
				Stack<Integer> stack = new Stack<>();
				int curSum = 0;
				List<Integer> ans = new ArrayList<>();

				for (int v : w)
					curSum += v;

				if (curSum == x) {
					o.println("NO");
				} else {
					curSum = 0;

					for (int i = 0; i < n; ++i)
						stack.push(i);

					while (!stack.isEmpty()) {
						int i1 = stack.pop();

						if (curSum + w[i1] != x) {
							ans.add(w[i1]);

							curSum += w[i1];
						} else {
							int i2 = stack.pop();
							curSum += w[i2];

							stack.push(i1);
							ans.add(w[i2]);
						}
					}

					o.println("YES");

					for (int v : ans)
						o.print(v + " ");

					o.println();
				}
			}
		}

		o.flush();
		o.close();
	}
}