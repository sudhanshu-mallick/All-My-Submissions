import java.util.*;
import java.io.*;

public class Balanced_Array {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();

			if (n % 4 == 0) {
				o.println("YES");
				int k = 2;
				for (int i = 0; i < n / 2; ++i) {
					o.print(k + " ");
					k += 2;
				}

				k = 1;
				for (int i = 0; i < n / 2 - 1; ++i) {
					o.print(k + " ");
					k += 2;
				}

				o.println(k + n / 2);
			} else {
				o.println("NO");
			}
		}

		o.flush();
		o.close();
	}
}