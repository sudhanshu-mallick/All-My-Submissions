import java.util.*;
import java.io.*;

public class Parking_Lot {

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

		if (n != 3) {
			long pow = n - 4;
			long four = pow(pow);
			long ans = 12 * four * (3 * n - 1);

			o.println(ans);
		} else
			o.println("24");

		o.flush();
		o.close();
	}

	private static long pow(long pow) {
		long ans = 1, cur = 4;

		while (pow > 0) {
			if ((pow & 1) == 1)
				ans = ans * cur;

			cur = cur * cur;
			pow >>= 1;
		}
		return ans;
	}
}