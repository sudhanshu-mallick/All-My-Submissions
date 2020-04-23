import java.util.*;
import java.io.*;

public class Natsya_And_Door {

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
			int n = t.nextInt();
			int k = t.nextInt();
			int count[] = new int[n];
			int[] a = new int[n];
			int max = 0, midx = 0;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = 1; i < n - 1; ++i) {
				if (a[i] > a[i + 1] && a[i] > a[i - 1])
					count[i] = count[i - 1] + 1;
				else
					count[i] = count[i - 1];
			}

			for (int i = k - 1; i < n; ++i) {
				int val = count[i - 1] - count[i - k + 1];

				if (val > max) {
					max = val;
					midx = i - k + 1;
				}
			}

			o.println(max + 1 + " " + (midx + 1));
		}

		o.flush();
		o.close();
	}
}
