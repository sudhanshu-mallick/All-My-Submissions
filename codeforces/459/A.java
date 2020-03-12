import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Pashmak_And_Garden {

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
		int x1 = t.nextInt();
		int y1 = t.nextInt();
		int x2 = t.nextInt();
		int y2 = t.nextInt();
		int y3 = 0, y4 = 0, x3 = 0, x4 = 0;

		if (x1 - x2 == 0) {
			x3 = x1 + y2 - y1;
			x4 = x2 + y2 - y1;
			y3 = y1;
			y4 = y2;

			o.println(x3 + " " + y3 + " " + x4 + " " + y4);
		} else if (y1 - y2 == 0) {
			x3 = x1;
			x4 = x2;
			y3 = y1 + x2 - x1;
			y4 = y2 + x2 - x1;

			o.println(x3 + " " + y3 + " " + x4 + " " + y4);
		} else if (Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
			x3 = x2;
			y3 = y1;
			x4 = x1;
			y4 = y2;

			o.println(x3 + " " + y3 + " " + x4 + " " + y4);
		} else
			o.println(-1);

		o.flush();
		o.close();
	}

}
