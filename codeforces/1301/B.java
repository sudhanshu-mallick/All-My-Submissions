import java.util.*;
import java.io.*;

public class Motaracks_Birthday {

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
		int[] a = new int[100000];

		while (test-- > 0) {
			int n = t.nextInt(), max = -1000000000, min = 1000000000;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = 0; i < n; i++) {
				if (i > 0 && a[i] == -1 && a[i - 1] != -1) {
					min = Math.min(min, a[i - 1]);
					max = Math.max(max, a[i - 1]);
				}

				if (i < n - 1 && a[i] == -1 && a[i + 1] != -1) {
					min = Math.min(min, a[i + 1]);
					max = Math.max(max, a[i + 1]);
				}
			}
			int res = (max + min) / 2;
			int ans = 0;

			for (int i = 0; i < n; i++) {
				if (a[i] == -1)
					a[i] = res;

				if (i > 0)
					ans = Math.max(ans, Math.abs(a[i] - a[i - 1]));
			}

			o.println(ans + " " + res);

		}

		o.flush();
		o.close();
	}
}