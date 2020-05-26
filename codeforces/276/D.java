import java.util.*;
import java.io.*;

public class Little_Girl_And_Maximum_XOR {

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
		long l = t.nextLong();
		long r = t.nextLong();

		if (r - l > 1) {
			long cur = 0;
			long inc = 1;
			long pos = 0;

			while (r - l >= inc) {
				cur += inc;
				inc = inc << 1;
				++pos;
			}

			while (r >= inc) {
				if ((((l >> pos) ^ (r >> pos)) & 1) == 1)
					cur += inc;

				inc = inc << 1;
				pos++;
			}

			o.println(cur);

		} else
			o.println(r ^ l);

		o.flush();
		o.close();
	}
}