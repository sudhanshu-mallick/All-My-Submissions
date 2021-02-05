import java.util.*;
import java.io.*;

public class Vasya_And_Multiset {

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
		int n = t.nextInt();
		int[] a = new int[n];
		int[] cnt = new int[100];
		int one = 0, threeMore = 0;

		for (int i = 0; i < n; ++i) {
			cnt[(a[i] = t.nextInt() - 1)]++;
		}

		for (int i = 0; i < 100; ++i) {
			if (cnt[i] == 1)
				++one;
			else if (cnt[i] > 2)
				++threeMore;
		}

		if ((one & 1) == 0 || threeMore >= 1) {
			o.println("YES");

			StringBuilder sb = new StringBuilder();
			boolean flag = false;
			int idx = -1;

			for (int i = 0; i < n; ++i) {
				if (cnt[a[i]] >= 3) {
					idx = i;
					break;
				}
			}

			if ((one & 1) == 0) {
				for (int i = 0; i < n; ++i) {
					if (cnt[a[i]] != 1) {
						sb.append("A");
					} else {
						if (flag) {
							sb.append("B");
						} else {
							sb.append("A");
						}

						flag = !flag;
					}
				}
			} else {
				for (int i = 0; i < n; ++i) {
					if (cnt[a[i]] == 1) {
						if (flag) {
							sb.append("B");
						} else {
							sb.append("A");
						}

						flag = !flag;
					} else if (i == idx) {
						sb.append("B");
					} else {
						sb.append("A");
					}
				}
			}

			o.println(sb);
		} else {
			o.println("NO");
		}

		o.flush();
		o.close();
	}
}
