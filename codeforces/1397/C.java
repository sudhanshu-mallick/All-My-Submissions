import java.util.*;
import java.io.*;

public class Multiples_Of_Length {

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

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		if (n == 1) {
			o.println("1 1");
			o.println(-a[0]);
			o.println("1 1");
			o.println("0");
			o.println("1 1");
			o.println("0");

		} else {
			o.println("2 " + n);

			for (int i = 1; i < n; ++i) {
				long rem = a[i] > 0 ? a[i] % n : (n - (-a[i]) % n);
				rem = (n - rem) % n;

				if (rem == 0) {
					o.print("0 ");
				} else {
					long v = (n - rem) * (n - 1);
					a[i] += v;

					o.print(v + " ");
				}
			}

			o.println("\n1 1");
			o.println(-a[0]);
			o.println("1 " + n);

			a[0] = 0;

			for (int i = 0; i < n; ++i) {
				o.print(-a[i] + " ");
			}

		}

		o.flush();
		o.close();
	}
}