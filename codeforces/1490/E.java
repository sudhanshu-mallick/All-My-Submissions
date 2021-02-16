import java.util.*;
import java.io.*;

public class Accidental_Victory {

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
			long[] a = new long[n];
			ArrayList<Long> list = new ArrayList<>();

			for (int i = 0; i < n; ++i) {
				long x = t.nextLong();
				a[i] = x;

				list.add(x);
			}

			Collections.sort(list);

			int left = 0, right = n - 1;
			int ok = n - 1;

			while (left <= right) {
				int mid = ((right + left) >> 1);
				boolean res = true;
				long curSum = 0;

				for (int i = 0; i <= mid; ++i) {
					curSum += list.get(i);
				}

				for (int i = mid + 1; i < n; ++i) {
					if (curSum >= list.get(i)) {
						curSum += list.get(i);
					} else {
						res = false;
						break;
					}
				}

				if (res) {
					right = mid - 1;
					ok = mid;
				} else {
					left = mid + 1;
				}
			}

			List<Integer> ans = new ArrayList<>();

			for (int i = 0; i < n; ++i)
				if (a[i] >= list.get(ok))
					ans.add(i + 1);

			o.println(ans.size());

			for (int v : ans)
				o.print(v + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}