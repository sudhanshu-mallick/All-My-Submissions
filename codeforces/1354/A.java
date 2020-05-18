import java.util.*;
import java.io.*;

public class Alarm_Clock {

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
			long a = t.nextLong();
			long b = t.nextLong();
			long c = t.nextLong();
			long d = t.nextLong();

			if (b >= a)
				o.println(b);
			else {
				if (d >= c)
					o.println("-1");
				else {
					long dif = c - d;
					long tim = (long) Math.ceil((double) (a - b) / (double) dif);
					long ans = b + c * tim;

					o.println(ans);
				}
			}
		}

		o.flush();
		o.close();
	}
}