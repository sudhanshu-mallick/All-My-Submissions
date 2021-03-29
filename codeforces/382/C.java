import java.util.*;
import java.io.*;

public class Arithemetic_Progression {

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

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		shuffle(a);

		if (n == 1) {
			o.println("-1");
		} else if (n == 2) {
			if (((a[1] - a[0]) & 1) == 0) {
				if (a[1] - a[0] == 0) {
					o.println("1");
					o.println(a[1]);
				} else {
					o.println("3");

					int dif = a[1] - a[0];
					dif >>= 1;

					o.println((a[0] - (dif << 1)) + " " + (a[0] + dif) + " " + (a[1] + (dif << 1)));
				}
			} else {
				o.println("2");

				int dif = a[1] - a[0];

				o.println((a[0] - dif) + " " + (a[1] + dif));
			}
		} else {
			int max = 0, idx = -1, count = 0;
			Set<Integer> set = new HashSet<>();

			for (int i = 1; i < n; ++i) {
				int dif = a[i] - a[i - 1];

				if (max < dif) {
					max = dif;
					idx = i;
					count = 1;
				} else if (max == dif) {
					idx = i;
					++count;
				}

				set.add(dif);
			}

			if (set.size() > 2)
				o.println("0");
			else if (set.size() == 2) {
				if ((max & 1) != 0)
					o.println("0");
				else if (count > 1)
					o.println("0");
				else {
					max >>= 1;

					if (set.contains(max)) {
						o.println("1");
						o.println(a[idx - 1] + max);
					} else {
						o.println("0");
					}
				}
			} else {
				if (max == 0) {
					o.println("1");
					o.print(a[0]);
				} else {
					o.println("2");
					o.println((a[0] - max) + " " + (a[n - 1] + max));
				}
			}

//			if (n == 298) {
//				o.println(set.size());
//				o.println(set);
//			}
		}

		o.flush();
		o.close();
	}
}
