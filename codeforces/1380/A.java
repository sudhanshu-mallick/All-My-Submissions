import java.util.*;
import java.io.*;

public class Three_Indices {

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
		StringBuilder sb = new StringBuilder();

		while (test-- > 0) {
			int n = t.nextInt();
			int[] a = new int[n];
			boolean flag = false;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = 1; i < n - 1; ++i) {
				if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
					sb.append("YES\n");
					sb.append(i + " ");
					sb.append(i + 1 + " ");
					sb.append(i + 2 + " ");
					flag = true;
					break;
				}
			}

			if (!flag)
				sb.append("NO");

			sb.append("\n");
		}

		o.println(sb);
		o.flush();
		o.close();
	}
}
