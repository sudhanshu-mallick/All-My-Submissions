import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Amr_And_Pins {

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
		double r = t.nextDouble(), x0 = t.nextDouble(), y0 = t.nextDouble(), x = t.nextDouble(), y = t.nextDouble();
		double dx = x0 - x, dy = y0 - y;

		if (dx == dy && dx == 0)
			o.println(0);
		else {
			double R = Math.sqrt(dx * dx + dy * dy);
			double ans = Math.ceil(R / (2 * r) - 1) + 1;

			o.println((int) ans);
		}

		o.flush();
		o.close();
	}

}
