import java.util.*;
import java.io.*;

public class Color_The_Fence {

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
		int[] a = new int[9];
		int min = Integer.MAX_VALUE;
		int idx = -1;

		for (int i = 0; i < 9; ++i) {
			a[i] = t.nextInt();

			if (a[i] <= min) {
				min = a[i];
				idx = i;
			}
		}

		int val = n / min;

		if (val == 0)
			o.println("-1");
		else {
			StringBuilder ans = new StringBuilder();

			for (int i = val; i >= 1; --i) {
				for (int j = 8; j >= idx; --j) {
					if (a[j] <= n - (i - 1) * min) {
						ans.append(j + 1);

						n -= a[j];
						break;
					}
				}
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}