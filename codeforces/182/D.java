import java.util.*;
import java.io.*;

public class Common_Divisors {

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
		String x = t.next();
		String y = t.next();
		int m = x.length();
		int n = y.length();
		int v = Math.min(m, n);
		int count = 0;

		for (int i = 1; i * i <= v; ++i) {
			if ((v % i) == 0) {
				int v1 = i;
				int v2 = v / i;
				String pre = x.substring(0, v1);
				boolean flag = m % v1 == 0 && n % v1 == 0;

				if (flag)
					for (int j = 0; j < x.length(); j += v1)
						if (!x.substring(j, j + v1).equals(pre)) {
							flag = false;
							break;
						}

				if (flag)
					for (int j = 0; j < y.length(); j += v1)
						if (!y.substring(j, j + v1).equals(pre)) {
							flag = false;
							break;
						}

//				System.out.println(flag + " " + pre);

				if (flag) {
					++count;
				}

				if (v1 != v2) {
					pre = x.substring(0, v2);
					flag = m % v2 == 0 && n % v2 == 0;

					if (flag)
						for (int j = 0; j < x.length(); j += v2)
							if (!x.substring(j, j + v2).equals(pre)) {
								flag = false;
								break;
							}

					if (flag)
						for (int j = 0; j < y.length(); j += v2)
							if (!y.substring(j, j + v2).equals(pre)) {
								flag = false;
								break;
							}

					if (flag) {
						++count;
					}

//					System.out.println(flag + " " + pre);
				}
			}
		}

		o.println(count);
		o.flush();
		o.close();
	}
}