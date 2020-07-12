import java.util.*;
import java.io.*;

public class Create_The_Teams {

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
			long x = t.nextLong();
			Long[] a = new Long[n];
			int count = 0;
			int cur = 1;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextLong();

			Arrays.sort(a);

			for (int i = n - 1; i >= 0; --i) {
				if (cur * a[i] >= x) {
					count++;
					cur = 1;
				} else
					cur++;
			}

			o.println(count);
		}

		o.flush();
		o.close();
	}
}