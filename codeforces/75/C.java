import java.util.*;
import java.io.*;

public class Modified_GCD {

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
		long a = t.nextLong(), b = t.nextLong();
		long gcd = gcd(a, b);
		TreeSet<Long> set = new TreeSet<>();

		for (long i = 1; i * i <= gcd; ++i) {
			if (gcd % i == 0) {
				set.add(i);
				set.add(gcd / i);
			}
		}

		int test = t.nextInt();

		while (test-- > 0) {
			long low = t.nextLong(), high = t.nextLong();
			Long nowGcd = set.floor(high);

			if (nowGcd != null && nowGcd.longValue() >= low)
				o.println(nowGcd);
			else
				o.println("-1");

		}

		o.flush();
		o.close();
	}

	private static long gcd(long a, long b) {
		if (a == 0)
			return b;

		return gcd(b % a, a);
	}
}