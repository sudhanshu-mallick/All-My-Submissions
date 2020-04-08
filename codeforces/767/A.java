import java.util.*;
import java.io.*;

public class Snacktower {

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
		int[] a = new int[n];
		int expected = n - 1;
		boolean[] list = new boolean[n];

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt() - 1;

		for (int i = 0; i < n; i++) {
			list[a[i]] = true;

			while (expected >= 0 && list[expected]) {
				o.print(expected + 1 + " ");
				--expected;
			}

			o.println();
		}

		o.flush();
		o.close();
	}
}