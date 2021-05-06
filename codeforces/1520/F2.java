import java.util.*;
import java.io.*;

public class Guess_The_Kth_Zero {

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

	private static FastReader t = new FastReader();
	private static PrintWriter o = new PrintWriter(System.out);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = t.nextInt();
		int tt = t.nextInt();
		int[] a = new int[n + 1];
		List<Integer> list = new ArrayList<>();

		Arrays.fill(a, -1);

		while (tt-- > 0) {
			int k = t.nextInt();
			int low = 1, high = n, ans = 1;

			while (low <= high) {
				int mid = (low + high) >> 1;
				int x = a[mid];

				if (x == -1) {
					int val = query(mid);
					x = a[mid] = val;

					int idx = get(list, mid);

					list.add(idx, mid);
				}

				if (mid - x >= k) {
					ans = mid;
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

			o.println("! " + ans);
			o.flush();

			int idx = get(list, ans - 1);

			for (int i = idx; i < list.size(); ++i)
				++a[list.get(i)];
		}

		o.flush();
		o.close();
	}

	private static int query(int j) {
		o.println("? 1 " + j);
		o.flush();

		return t.nextInt();
	}

	private static int get(List<Integer> list, int val) {
		if (list.size() == 0)
			return 0;

		int low = 0, high = list.size() - 1, ans = 0;

		while (low <= high) {
			int mid = (low + high) >> 1;

			if (list.get(mid) > val)
				high = mid - 1;
			else {
				low = mid + 1;
				ans = low;
			}
		}

		return ans;
	}
}