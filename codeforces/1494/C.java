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
			int n = t.nextInt();
			int m = t.nextInt();
			Stack<Integer> negBox = new Stack<Integer>();
			Stack<Integer> negSpec = new Stack<Integer>();
			ArrayList<Integer> posBox = new ArrayList<Integer>();
			ArrayList<Integer> posSpec = new ArrayList<Integer>();

			for (int i = 0; i < n; i++) {
				int x = t.nextInt();

				if (x > 0) {
					posBox.add(x);
				} else {
					negBox.add(-x);
				}
			}

			for (int i = 0; i < m; i++) {
				int x = t.nextInt();
				if (x > 0) {
					posSpec.add(x);
				} else {
					negSpec.add(-x);
				}
			}

			ArrayList<Integer> negBoxal = new ArrayList<Integer>();

			while (!negBox.isEmpty()) {
				negBoxal.add(negBox.pop());
			}

			ArrayList<Integer> negSpecal = new ArrayList<Integer>();

			while (!negSpec.isEmpty()) {
				negSpecal.add(negSpec.pop());
			}

			o.println(solve(posBox, posSpec) + solve(negBoxal, negSpecal));
		}

		o.flush();
		o.close();
	}

	private static int solve(List<Integer> pos, List<Integer> spec) {
		int n = pos.size();
		int m = spec.size();
		int[] suf = new int[n + 1];
		int r = m - 1;

		for (int i = n - 1; i >= 0; --i) {
			suf[i] = suf[i + 1];

			while (r >= 0 && spec.get(r).intValue() > pos.get(i).intValue())
				--r;

			if (r >= 0 && spec.get(r).intValue() == pos.get(i).intValue())
				++suf[i];
		}

		int ans = 0;
		int j = 0;
		r = 0;

		for (int l = 0; l < m; ++l) {
			while (j < n && pos.get(j).intValue() <= spec.get(l).intValue() + j)
				++j;

			while (r < m && spec.get(r).intValue() - spec.get(l).intValue() < j)
				++r;

			ans = Math.max(ans, r - l + suf[j]);
		}

		return ans;
	}
}