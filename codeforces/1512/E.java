import java.util.*;
import java.io.*;

public class Permutation_By_Sum {

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
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			Set<Integer> set = new HashSet<>();
			int n = t.nextInt();
			int l = t.nextInt() - 1;
			int r = t.nextInt() - 1;
			int s = t.nextInt();
			boolean flag = true;
			int[] ans = new int[n];

			for (int i = 0; i < n; ++i)
				set.add(i + 1);

			int j = r;
			int cur = n;

			while (j >= l) {
				int not = j - l;
				int sum = not * (not + 1) / 2;

				if (sum > s) {
					flag = false;

					break;
				}

				if (s - cur > sum) {
//					System.out.println(set);

					if (set.contains(cur)) {
						set.remove(cur);

						ans[j] = cur;
						s -= cur;
						--cur;
					} else {
						flag = false;

						break;
					}
				} else {
					int dif = s - sum;

					if (set.contains(dif)) {
						set.remove(dif);

						ans[j] = dif;
						s -= dif;
					} else {
						flag = false;

						break;
					}
				}
				
				--j;
			}

//			for (int i = 0; i < n; ++i)
//				System.out.print(ans[i] + " ");
//
//			System.out.println(flag);

			if (s > 0)
				flag = false;

			if (flag) {
				int i = 0;

				for (int val : set) {
					while (ans[i] != 0)
						++i;

					ans[i++] = val;
				}
			}

			if (flag) {
				for (int v : ans)
					o.print(v + " ");

				o.println();
			} else {
				o.println("-1");
			}

		}

		o.flush();
		o.close();
	}
}