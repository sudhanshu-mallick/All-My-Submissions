import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MashMokh_And_ACM {

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
		int k = t.nextInt();
		long ans = 0;
		long[][] a = new long[k][n];

		for (int i = 0; i < n; i++)
			a[0][i] = 1;

		for (int i = 1; i < k; i++) {
			for (int j = 0; j < n; j++) {
				for (int p = j + 1; p <= n; p += j + 1) {
					a[i][j] = (a[i][j] + a[i - 1][p - 1]) % 1000000007;
				}
			}
		}

		for (int i = 0; i < n; i++)
			ans = (ans + a[k - 1][i]) % 1000000007;

		o.println(ans);
		o.flush();
		o.close();
	}

}