
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
		List<Long> list = new ArrayList<>();

		for (long i = 1; i * i <= gcd; ++i) {
			if (gcd % i == 0) {
				list.add(i);
				list.add(gcd / i);
			}
		}

		Collections.sort(list);

		int test = t.nextInt();

		while (test-- > 0) {
			long low = t.nextLong(), high = t.nextLong();
			int x = 0, y = list.size() - 1;
			long ans = -1;

			while (x <= y) {
				int mid = (x + y) >> 1;

				if (list.get(mid).longValue() <= high) {
					ans = list.get(mid);
					x = mid + 1;
				} else
					y = mid - 1;
			}

			o.println(ans >= low ? ans : -1);
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