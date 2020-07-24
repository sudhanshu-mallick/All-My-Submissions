import java.util.*;
import java.io.*;

public class Common_Prefixes {

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
			int max = 0;
			StringBuilder[] sb = new StringBuilder[n + 1];

			for (int i = 0; i <= n; ++i)
				sb[i] = new StringBuilder();

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();
				max = Math.max(max, a[i]);
			}

			for (int i = 0; i < max + 1; ++i)
				sb[0].append("a");

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < a[i]; ++j)
					sb[i + 1].append(sb[i].charAt(j));

				for (int j = a[i]; j <= max; ++j)
					sb[i + 1].append((char) (((sb[i].charAt(j) - 'a' + 1) % 26) + 'a'));

			}

			for (StringBuilder s : sb)
				o.println(s);
		}

		o.flush();
		o.close();
	}
}
