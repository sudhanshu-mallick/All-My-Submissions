import java.util.*;
import java.io.*;

public class Pluses_And_Minuses {

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
		int test = t.nextInt();

		while (test-- > 0) {
			String s = t.next();
			int n = s.length();
			long[] pre = new long[n];
			int[] a = new int[n];
			Arrays.fill(a, -1);
			long min = Long.MAX_VALUE;
			long ans = 0;
			int pos = -1;

			if (s.charAt(0) == '-')
				pre[0] = -1;
			else
				pre[0] = 1;

			min = pre[0];

			if (min < 0 && a[(int) Math.abs(min) - 1] == -1)
				a[(int) Math.abs(min) - 1] = 0;

			for (int i = 1; i < n; ++i) {
				if (s.charAt(i) == '+')
					pre[i] = pre[i - 1] + 1;
				else
					pre[i] = pre[i - 1] - 1;

				if (min > pre[i]) {
					min = pre[i];

					if (min < 0 && a[(int) Math.abs(min) - 1] == -1)
						a[(int) Math.abs(min) - 1] = i;
				}
			}

			if (min < 0) {
				ans = n;

				for (int i = 0; i < n; ++i) {
					if (a[i] == -1)
						break;

					ans += (a[i] + 1);
				}
			} else {
				ans = n;
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}