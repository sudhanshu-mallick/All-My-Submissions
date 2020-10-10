import java.util.*;
import java.io.*;

public class Avoiding_Zero {

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
			int[] a = new int[n];
			int sum = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();
				sum += a[i];
			}

			if (sum == 0)
				o.println("NO");
			else {
				Arrays.sort(a);
				o.println("YES");

				if (sum > 0)
					for (int i = n - 1; i >= 0; --i) {
						o.print(a[i] + " ");
					}
				else {
					for (int i : a) {
						o.print(i + " ");
					}
				}

				o.println();
			}
		}

		o.flush();
		o.close();
	}
}