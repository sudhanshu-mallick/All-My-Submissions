import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Random_Teams {

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
		long m = t.nextLong(), n = t.nextLong();

		long min = min(m, n);
		long max = max(m, n);

		o.println(min + " " + max);
		o.flush();
		o.close();
	}

	private static long min(long m, long n) {
		long k = m / n;
		long x = n * (k + 1) - m;
		long y = m - n * k;
		long ans = x * (k) * (k - 1) / 2 + y * (k + 1) * (k) / 2;

		return ans;
	}

	private static long max(long m, long n) {
		long ans = 0;

		if (n > 1) {
			n = m - n + 1;
			ans = (n) * (n - 1) / 2;
		} else
			ans = m * (m - 1) / 2;

		return ans;
	}

}
