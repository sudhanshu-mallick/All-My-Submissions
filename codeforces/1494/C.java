import java.util.*;
import java.io.*;

public class _1D_Sokoban {

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
			int m = t.nextInt();
			int n = t.nextInt();
			List<Integer> pos = new ArrayList<>();
			List<Integer> neg = new ArrayList<>();
			List<Integer> posSpec = new ArrayList<>();
			List<Integer> negSpec = new ArrayList<>();

			for (int i = 0; i < m; ++i) {
				int x = t.nextInt();

				if (x > 0)
					pos.add(x);
				else
					neg.add(-x);
			}

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt();

				if (x > 0)
					posSpec.add(x);
				else
					negSpec.add(-x);
			}

			Collections.reverse(negSpec);
			Collections.reverse(neg);

			int left = solve(neg, negSpec);
			int right = solve(pos, posSpec);

//			System.out.println(left + " " + right);

			o.println(left + right);
		}

		o.flush();
		o.close();
	}

	private static int solve(List<Integer> pos, List<Integer> spec) {
		if (pos.isEmpty() || spec.isEmpty() || spec.get(spec.size() - 1).intValue() < pos.get(0).intValue())
			return 0;

		int j = 0;
		int[] dp = new int[pos.size() + 1];
		int x = pos.size() - 1;
		int y = spec.size() - 1;

		while (x >= 0) {
			if (y < 0) {
				dp[x] = dp[x + 1];
				--x;
			} else if (pos.get(x).intValue() == spec.get(y).intValue()) {
				--y;
				dp[x] = dp[x + 1] + 1;
				--x;
			} else if (pos.get(x).intValue() > spec.get(y).intValue()) {
				dp[x] = dp[x + 1];
				--x;
			} else
				--y;
		}

		while (spec.get(j).intValue() < pos.get(0).intValue())
			++j;

		int max = dp[0];
		int idx = 0;

		while (j < spec.size()) {
			x = 0;
			y = pos.size() - 1;
			int right = y;

			while (x <= y) {
				int mid = (x + y) >> 1;

				if (pos.get(mid).intValue() > spec.get(j).intValue() + mid) {
					y = mid - 1;
				} else {
					x = mid + 1;
					right = mid;
				}
			}

			while (idx < spec.size() && spec.get(idx).intValue() <= spec.get(j).intValue() + right) {
				++idx;
			}

//			System.out.println(right + " " + idx + " " + j);

			max = Math.max(max, idx - j + dp[right + 1]);
			++j;
		}

//		System.out.println("Done");

		return max;
	}
}