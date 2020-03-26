import java.io.*;
import java.util.*;

public class K_th_Beautiful_String {

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
		int q = t.nextInt();

		while (q-- > 0) {
			long n = t.nextLong();
			long k = t.nextLong();
			StringBuilder sb = new StringBuilder();
			long a = 0, b = 0;
			boolean flag = false;

			for (long i = 0; i < n; i++) {
				if (k <= i + 1) {
					a = i + 1;
					b = k - 1;
					flag = true;
				} else
					k -= (i + 1);

				if (flag)
					break;
			}

			for (long i = n - 1; i >= 0; i--) {
				if (i == a || i == b)
					sb.append('b');
				else
					sb.append('a');
			}

			o.println(sb);
		}
		o.flush();
		o.close();
	}
}