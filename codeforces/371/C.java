import java.util.*;
import java.io.*;

public class Hamburgers {

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
		String s = t.next();
		long[] req = new long[3];
		long[] have = new long[3];
		long[] price = new long[3];

		for (char ch : s.toCharArray()) {
			if (ch == 'B')
				++req[0];
			else if (ch == 'S')
				++req[1];
			else
				++req[2];
		}

		for (int i = 0; i < 3; ++i)
			have[i] = t.nextLong();

		for (int i = 0; i < 3; ++i)
			price[i] = t.nextLong();

		long cost = t.nextLong();
		long left = 0, right = (long) (1e12) + have[0] + have[1] + have[2], ans = right + have[0] + have[1] + have[2];

		while (left <= right) {
			long mid = (left + right) >> 1;
			boolean flag = true;
			long sum = 0;

			for (int i = 0; i < 3; ++i) {
				if (mid * req[i] > have[i])
					sum += (mid * req[i] - have[i]) * price[i];
			}

			if (sum <= cost) {
				left = mid + 1;
			} else {
				right = mid - 1;
				ans = right;
			}
		}

		o.println(ans);

		o.flush();
		o.close();
	}
}