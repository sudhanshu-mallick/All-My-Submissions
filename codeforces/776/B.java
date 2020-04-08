import java.util.*;
import java.io.*;

public class Sherlock_And_His_Girlfriend {

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
		int n = t.nextInt();

		soe(n + 1);
	}

	private static void soe(int n) {
		PrintWriter o = new PrintWriter(System.out);
		boolean prime[] = new boolean[n + 1];

		for (int i = 0; i < n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			if (prime[p] == true) {
				for (int i = p * p; i <= n; i += p)
					prime[i] = false;
			}
		}

		if (n <= 3) {
			o.println(1);

			for (int i = 0; i < n - 1; i++)
				o.print(1 + " ");
		} else {
			o.println(2);

			for (int i = 0; i < n - 1; i++) {
				if (prime[i + 2])
					o.print(1 + " ");
				else
					o.print(2 + " ");
			}
		}

		o.flush();
		o.close();
	}
}