import java.util.*;
import java.io.*;

public class Our_Tanya_Is_Crying_Out_Loud {

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
		long k = t.nextLong();
		long a = t.nextLong();
		long b = t.nextLong();

		if (k == 1)
			o.println((n - 1) * a);
		else {
			long cur = 0;

			while (n > 1) {
				if (n % k == 0) {
					long v1 = b;
					long v2 = (n - n / k) * a;
					cur += Math.min(v1, v2);
					n = n / k;
				} else {
					cur += a * (n % k);
					n = n - n % k;

					if (n <= 1) {
						cur = cur - (1 - n) * a;
						break;
					}
				}

			}

			o.println(cur);
		}

		o.flush();
		o.close();
	}
}