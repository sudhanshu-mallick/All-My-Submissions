import java.util.*;
import java.io.*;

public class Kiril_And_The_Game {

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
		long x = t.nextLong();
		long y = t.nextLong();
		long k = t.nextLong();
		boolean ans = false;
		long i = x;

		while (i <= y) {
			if (k * i >= l && k * i <= r) {
				ans = true;
				break;
			}
//
//			if (k * i > y)
//				break;

			i++;
		}

		if (ans)
			o.println("YES");
		else
			o.println("NO");

		o.flush();
		o.close();
	}
}