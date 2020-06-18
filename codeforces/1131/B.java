import java.util.*;
import java.io.*;

public class Draw {

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
		int count = 1;
		int x = 0, y = 0;
		boolean f = true;
		while (test-- > 0) {
			int a = t.nextInt();
			int b = t.nextInt();

			if (x == y) {
				count += Math.min(a, b) - x;
				x = a;
				y = b;
			} else if (x > y) {
				int val = Math.min(a, b) - x + 1;
				count += val < 0 ? 0 : val;
				x = a;
				y = b;
			} else {
				int val = Math.min(a, b) - y + 1;
				count += val < 0 ? 0 : val;
				x = a;
				y = b;
			}
		}

		o.println(count);

		o.flush();
		o.close();
	}
}