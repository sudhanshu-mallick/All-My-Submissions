import java.util.*;
import java.io.*;

public class Number_Into_Sequence {

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
			long n = t.nextLong();
			List<long[]> list = new ArrayList<>();
			long count = 0;
			long ok = n;

			if ((n & 1) == 0) {
				while ((n & 1) == 0) {
					n = n >> 1;
					++count;
				}

				list.add(new long[] { 2, count });
			}

			for (long i = 3; i * i <= n; ++i) {
				long cnt = 0;

				if (n % i == 0) {
					count = 0;

					while (n % i == 0) {
						n /= i;
						++count;
					}

					list.add(new long[] { i, count });
				}
			}

			if (n > 1) {
				list.add(new long[] { n, 1 });
			}

			long max = 0;
			int idx = 0;

			for (int i = 0; i < list.size(); ++i) {
				if (max < list.get(i)[1]) {
					idx = i;
					max = list.get(i)[1];
				}
			}

			count = max - 1;
			long val = 1;

			o.println(max);

			while (count-- > 0) {
				o.print(list.get(idx)[0] + " ");

				val *= list.get(idx)[0];
			}

			o.println(ok / val);

		}

		o.flush();
		o.close();
	}
}
