import java.util.*;
import java.io.*;

public class Beautiful_Numbers {

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
			StringBuilder sb = new StringBuilder();
			int[] a = new int[n];

			for (int i = 0; i < n; ++i) {
				int x = t.nextInt();
				a[x - 1] = i;
			}

			int left = a[0];
			int right = a[0];

			for (int i = 0; i < n; ++i) {
				left = left < a[i] ? left : a[i];
				right = right > a[i] ? right : a[i];

				if (right - left != i)
					sb.append("0");
				else
					sb.append("1");
			}

			o.println(sb);
		}

		o.flush();
		o.close();
	}
}