import java.io.*;
import java.util.*;

public class Three_Displays {
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
		int[] b = new int[n];

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();
		}

		for (int i = 0; i < n; ++i) {
			b[i] = t.nextInt();
		}

		int ans = -1;

		for (int i = 1; i < n - 1; ++i) {
			int left = -1;
			int right = -1;

			for (int j = 0; j < i; ++j) {
				if (a[j] < a[i]) {
					left = left == -1 ? b[j] : b[j] < left ? b[j] : left;
				}
			}

			for (int j = i + 1; j < n; ++j) {
				if (a[j] > a[i]) {
					right = right == -1 ? b[j] : b[j] < right ? b[j] : right;
				}
			}

			if (left != -1 && right != -1) {
				if (ans == -1) {
					ans = b[i] + left + right;
				} else {
					ans = Math.min(ans, b[i] + left + right);
				}
			}

		}

		o.println(ans);

		o.flush();
		o.close();
	}
}