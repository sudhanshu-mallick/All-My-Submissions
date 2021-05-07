import java.util.*;
import java.io.*;

public class Nastia_And_A_Good_Array {

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
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			List<int[]> ans = new ArrayList<>();

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();

				if (min > a[i]) {
					min = a[i];
					minIdx = i;
				}
			}

			if (minIdx != n - 1) {
				ans.add(new int[] { minIdx, n - 1, a[n - 1], a[minIdx] });

				int temp = a[minIdx];
				a[minIdx] = a[n - 1];
				a[n - 1] = temp;
			}

			int i = n - 1;
			int cur = min + 1;

			while (i > 0) {
				ans.add(new int[] { i, i - 1, cur, min });

				a[i] = cur;
				++cur;
				--i;
			}

			a[0] = min;

			int next = n > 2 ? a[2] : 1000000007;
			int prev = a[0];
			cur = a[0];

			while (gcd(cur, prev) != 1 || gcd(cur, next) != 1)
				++cur;

			if (n > 2)
				ans.set(ans.size() - 1, new int[] { 0, 1, min, cur });

			o.println(ans.size());

			for (int[] aa : ans)
				o.println(aa[0] + 1 + " " + (aa[1] + 1) + " " + aa[2] + " " + aa[3]);
		}

		o.flush();
		o.close();
	}

	private static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}
}
