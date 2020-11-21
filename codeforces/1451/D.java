import java.util.*;
import java.io.*;

public class Circle_Game {

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
			long d = t.nextLong();
			long k = t.nextLong();
			long cur = k;

			while (cur * cur * 2 <= d * d) {
				cur += k;
			}

			cur -= k;

			if ((cur + k) * (cur + k) + cur * cur <= d * d) {
				o.println("Ashish");
			} else {
				o.println("Utkarsh");
			}
		}

		o.flush();
		o.close();
	}
}
