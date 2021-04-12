import java.util.*;
import java.io.*;

public class Short_Task {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(int[] a, int i, int j) {
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();
		int[] c = new int[1_000_000_1];
		int[] sieve = new int[1_000_000_1];
		int N = c.length - 1;

		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j += i) {
				sieve[j] += i;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (sieve[i] > N)
				continue;

			if (c[sieve[i]] == 0)
				c[sieve[i]] = i;
		}

		while (test-- > 0) {
			int n = t.nextInt();

			o.println(c[n] == 0 ? "-1" : c[n]);
		}

		o.flush();
		o.close();
	}
}