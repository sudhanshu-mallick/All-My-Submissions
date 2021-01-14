import java.util.*;
import java.io.*;

public class No_More_Inversions {

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
			int k = t.nextInt();
			int v = k - (n - k) - 1;

			for (int i = 1; i <= v; ++i)
				sb.append(i + " ");

			for (int i = k; i > v; --i)
				sb.append(i + " ");

			sb.append("\n");
		}

		o.println(sb);
		o.flush();
		o.close();
	}
}