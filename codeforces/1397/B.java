import java.util.*;
import java.io.*;

public class Power_Sequence {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt();
		long[] a = new long[n];
		long ans = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		Arrays.sort(a);

		if (n >= 50) {
			for (int i = 0; i < n; ++i)
				ans += a[i] - 1;

			o.println(ans);
		} else {
			long cur = 1;

			while (true) {
				long v = pow(cur, n - 1);

				if (v > a[n - 1])
					break;

				cur++;
			}

			long v1 = 0, v2 = 0;
			long cur1 = cur, cur2 = cur - 1;
			long now1 = 1, now2 = 1;

			for (int i = 0; i < n; ++i) {
				v1 += Math.abs(a[i] - now1);
				v2 += Math.abs(a[i] - now2);
				now1 *= cur1;
				now2 *= cur2;
			}

			o.println(Math.min(v1, v2));
		}

		o.flush();
		o.close();
	}

	private static long pow(long x, long y) {
		long ans = 1l;

		while (y > 0) {
			if ((y & 1) == 1)
				ans *= x;

			y = y >> 1;
			x = x * x;
		}

		return ans;
	}

}