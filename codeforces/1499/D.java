import java.util.*;
import java.io.*;

public class The_Number_Of_Pairs {

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
		int[] countFactors = new int[20000001];
		int test = t.nextInt();

		for (int i = 2; i < countFactors.length; ++i)
			if (countFactors[i] == 0)
				for (int j = i; j < countFactors.length; j += i)
					++countFactors[j];

		while (test-- > 0) {
			int c = t.nextInt();
			int d = t.nextInt();
			int x = t.nextInt();
			long count = 0;

			for (int i = 1; i * i <= x; ++i) {
				if (x % i == 0) {
					int f = (x / i) + d;
					count += (f % c == 0) ? pow(2, countFactors[f / c]) : 0;

					if ((x / i) != i) {
						int f1 = i + d;
						count += (f1 % c == 0) ? pow(2, countFactors[f1 / c]) : 0;
					}
				}
			}

			o.println(count);
		}

		o.flush();
		o.close();
	}

	private static int pow(int x, int y) {
		int temp;

		if (y == 0)
			return 1;

		temp = pow(x, y / 2);

		if (y % 2 == 0)
			return temp * temp;
		else {
			if (y > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}
}