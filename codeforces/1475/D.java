import java.util.*;
import java.io.*;

public class Cleaning_The_Phone {

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
			int n = t.nextInt();
			long m = t.nextLong();
			long sum = 0;
			List<Long> one = new ArrayList<>();
			List<Long> two = new ArrayList<>();
			long[] a = new long[n];

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong();
				sum += a[i];
			}

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt();

				if (x == 1)
					one.add(a[i]);
				else
					two.add(a[i]);
			}

			if (sum >= m) {
				Collections.sort(one, Collections.reverseOrder());
				Collections.sort(two, Collections.reverseOrder());

				long twoSum = 0;

				for (int i = 0; i < two.size(); ++i)
					twoSum += two.get(i);

				int j = two.size();
				int min = Integer.MAX_VALUE;
				long oneSum = 0;

				for (int i = 0; i <= one.size(); ++i) {
					while (j > 0 && twoSum - two.get(j - 1) + oneSum >= m) {
						--j;
						twoSum -= two.get(j);
					}

					if (oneSum + twoSum >= m)
						min = Math.min(min, i + (j << 1));

					if (i != one.size())
						oneSum += one.get(i);
				}

				o.println(min);
			} else {
				o.println("-1");
			}

		}

		o.flush();
		o.close();
	}
}