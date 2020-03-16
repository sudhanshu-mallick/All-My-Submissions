import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Han_Solo_And_Lazer_Gun {

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
		HashSet<Double> map = new HashSet<>();
		int x0 = t.nextInt(), y0 = t.nextInt(), mz = 0, mi = 0;

		while (test-- > 0) {
			int x = t.nextInt(), y = t.nextInt();
			int dx = x0 - x, dy = y0 - y;

			if (dx == 0)
				mi = 1;
			else if (dy == 0)
				mz = 1;
			else {
				double d = (double) dy / (double) dx;
				map.add(d);
			}
		}

		o.println(map.size() + mz + mi);
		o.flush();
		o.close();
	}

}
