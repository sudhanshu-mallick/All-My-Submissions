import java.util.*;
import java.io.*;

public class Restore_Modulo {

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
			long a[] = new long[n];

			for (int i = 0; i < n; ++i)
				a[i] = t.nextLong();

			if (n == 1) {
				o.println("0");
			} else {
				boolean flag = true;
				int idx = -1;

				for (int i = 1; i < n; ++i) {
					if (a[i] >= a[i - 1]) {
						flag = false;
						idx = i - 1;
					}
				}

				if (flag) {
					long dif = a[0] - a[1];
					flag = true;

					for (int i = 2; i < n; ++i) {
						if (a[i - 1] - a[i] != dif) {
							flag = false;
							break;
						}
					}

					if (flag)
						o.println("0");
					else
						o.println("-1");
				} else {
					long c = a[idx + 1] - a[idx];
					flag = true;
					idx = -1;
					long m = -1;

					for (int i = 1; i < n; ++i) {
						if (a[i] < a[i - 1]) {
							flag = false;
							idx = i;
						}
					}

					if (flag) {
						long dif = a[1] - a[0];
						flag = true;

						for (int i = 2; i < n; ++i)
							if (a[i] - a[i - 1] != dif) {
								flag = false;
								break;
							}

						if (flag)
							o.println("0");
						else
							o.println("-1");
					} else {
						m = a[idx - 1] + c - a[idx];
						flag = true;

						for (long v : a) {
							if (v >= m) {
								flag = false;
								break;
							}
						}

						for (int i = 1; i < n; ++i) {
							if (a[i] != (a[i - 1] + c) % m) {
								flag = false;
								break;
							}
						}

						if (flag)
							o.println(m + " " + c);
						else
							o.println("-1");
					}
				}
			}
		}

		o.flush();
		o.close();
	}
}