import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Common_Divisors {

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
		long[] a = new long[n];
		long min = Long.MAX_VALUE;

		for (int i = 0; i < n; i++)
			a[i] = t.nextLong();

		long div = cd(a, n);
		long s = div(div);

		o.println(s);
		o.flush();
		o.close();
	}

	static long div(long n) {
		ArrayList<Long> a = new ArrayList<>();

		for (long i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i == i)
					a.add(i);

				else {
					a.add(i);
					a.add(n / i);
				}
			}
		}

		return a.size();
	}

	static long gcd(long a, long b) {
		if (a == 0)
			return b;

		return gcd(b % a, a);
	}

	static long cd(long a[], int n) {
		long result = a[0];
		for (int i = 1; i < n; i++) {
			result = gcd(a[i], result);

			if (result == 1)
				return 1;
		}

		return result;
	}
}
