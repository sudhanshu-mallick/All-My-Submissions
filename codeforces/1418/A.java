import java.util.*;
import java.io.*;

public class Buying_Torches {

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
			long x = t.nextLong();
			long y = t.nextLong();
			long k = t.nextLong();
			long req = y * k + k;
			long cur = 1;
			long sum = 0;

			while (cur <= (req) / x) {
				sum += cur;
				cur *= x;
			}

			sum += (req - cur + (x - 2)) / (x - 1);

			o.println(sum + k);
		}

		o.flush();
		o.close();
	}
}