import java.util.*;
import java.io.*;

public class shuffle {

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
			long n = t.nextLong();
			long x = t.nextLong();
			long m = t.nextLong();
			long min = x, max = x;

			while (m-- > 0) {
				long l = t.nextLong();
				long r = t.nextLong();

				if ((l < min && r < min) || (l > max && r > max)) {

				} else {
					min = Math.min(l, min);
					max = Math.max(r, max);
				}
			}

			o.println(max - min + 1);
		}

		o.flush();
		o.close();
	}
}