
import java.util.*;
import java.io.*;

public class T_Primes {

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
		int n = (int) (1e6);
		boolean prime[] = new boolean[n + 1];

		for (int i = 0; i <= n; ++i)
			prime[i] = true;

		for (int j = 2; j * j <= n; ++j) {
			if (prime[j])
				for (int i = j * j; i <= n; i += j)
					prime[i] = false;
		}

		prime[0] = prime[1] = false;

		int test = t.nextInt();

		while (test-- > 0) {
			long x = t.nextLong();
			long rot = (long) Math.sqrt(x);

			if (rot * rot == x) {
				if (prime[(int) rot])
					o.println("YES");
				else
					o.println("NO");
			} else {
				o.println("NO");
			}
		}

		o.flush();
		o.close();
	}
}