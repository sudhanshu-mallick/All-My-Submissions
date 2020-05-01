import java.util.*;
import java.io.*;

public class Taxes {

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

		if (prime(n))
			o.println(1);
		else {
			if ((n & 1) == 0)
				o.println(2);
			else if (prime(n - 2))
				o.println(2);
			else
				o.println(3);
		}

		o.flush();
		o.close();
	}

	private static boolean prime(int n) {
		boolean ans = true;

		if (n == 2 || n == 3)
			return true;

		for (int i = 2; i * i <= n; ++i)
			if (n % i == 0)
				return false;

		return ans;
	}
}