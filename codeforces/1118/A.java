
import java.util.*;
import java.io.*;

public class Water_Buying {

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
		StringBuilder ans = new StringBuilder();

		while (test-- > 0) {
			long n = t.nextLong();
			long a = t.nextLong();
			long b = t.nextLong();

			if (a * 2 <= b) {
				ans.append(n * a + "\n");
			} else {
				long val = (n / 2) * b + (n & 1) * a;

				ans.append(val + "\n");
			}
		}

		o.println(ans);
		o.flush();
		o.close();
	}
}