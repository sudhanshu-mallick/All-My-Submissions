import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Fadi_And_Lcm {

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
		long x = t.nextLong();
		long a = 1;
		long b = x;

		for (long i = 1; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				if (gcd(i, x / i) == 1) {
					a = i;
					b = x / i;
				}
			}
		}

		o.println(a + " " + b);

		o.flush();
		o.close();
	}

	private static long gcd(long a, long b) {
		if (b == 0)
			return a;

		return gcd(b, a % b);
	}

}
