import java.util.*;
import java.io.*;

public class Mashmokh_And_Numbers {

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
		int k = t.nextInt();

		if (n == 1 || k < n / 2) {
			if (n == 1) {
				if (k > 0)
					o.print("-1");
				else
					o.print("1");
			} else
				o.print("-1");
		} else {
			int dif = k - (n / 2 - 1);

			o.print(dif + " ");
			o.print(2 * dif + " ");
			n -= 2;
			dif = dif * 2 + 1;

			while (n > 1) {
				o.print(dif + " ");
				o.print(dif + 1 + " ");
				dif += 2;
				n -= 2;
			}

			if (n == 1)
				o.print(dif);

		}

		o.flush();
		o.close();
	}
}