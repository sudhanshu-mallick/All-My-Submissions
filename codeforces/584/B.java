import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Kolya_And_Tanya {

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

		BigInteger b1 = new BigInteger("3").pow((int) (3 * n));
		BigInteger b2 = new BigInteger("7").pow((int) n);
		b1 = b1.subtract(b2);
		b1 = b1.remainder(new BigInteger("1000000007"));

		o.println(b1);

		o.flush();
		o.close();
	}
}