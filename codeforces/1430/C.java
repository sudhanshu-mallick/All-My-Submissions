import java.util.*;
import java.io.*;

public class Numbers_On_Whiteboard {

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
			int n = t.nextInt();

			o.println("2");

			if (n == 2)
				o.println("1 2");
			else {
				int then = n - 1;
				int now = (n + (n - 2)) / 2;

				o.println(n + " " + (n - 2));
				o.println(then + " " + now);

				now = (then + now) / 2;
				then = n - 3;

				while (then > 0) {
					o.println(then + " " + now);

					now = (then + now) / 2;
					then--;
				}
			}
		}

		o.flush();
		o.close();
	}
}