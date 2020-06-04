import java.util.*;
import java.io.*;

public class Candy_Boxes {

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
			long count = 0;

			for (int i = 0; i < n; ++i)
				a[t.nextInt() - 1]++;

			Arrays.sort(a);

			int i = n - 1, cur = a[n - 1] + 1;

			while (i >= 0) {
				if (cur <= 0)
					break;

				cur = Math.min(cur - 1, a[i]);
				count += cur;
				i--;
			}
			
			o.println(count);

		}

		o.flush();
		o.close();
	}
}