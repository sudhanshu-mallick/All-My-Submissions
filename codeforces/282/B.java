import java.util.*;
import java.io.*;

public class Painting_Eggs {

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
		int n = t.nextInt();
		long a = 0;
		long b = 0;
		StringBuilder sb = new StringBuilder();

		while (n-- > 0) {
			int x = t.nextInt();
			int y = t.nextInt();

			if (Math.abs(a + x - b) <= 500) {
				a += x;

				sb.append('A');
			} else {
				b += y;

				sb.append('G');
			}
		}

		if (Math.abs(a - b) <= 500)
			o.println(sb);
		else
			o.println("-1");

		o.flush();
		o.close();
	}
}