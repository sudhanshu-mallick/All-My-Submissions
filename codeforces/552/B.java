import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Vanya_And_Books {

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
		long n = t.nextLong();
		long ans = 0;

		while (n > 0) {
			int bit = bit(n);
			long rem = n - (long) Math.pow(10, bit - 1) + 1;
			ans = (ans + rem * bit);
			n = (int) Math.pow(10, bit - 1) - 1;
		}

		o.println(ans);
		o.flush();
		o.close();
	}

	private static int bit(long n) {
		int k = 0;

		while (n > 0) {
			n /= 10;
			k++;
		}

		return k;
	}

}
