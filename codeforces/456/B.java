import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Fedya_And_Maths {

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
		String s = t.next();
		int n;

		if (s.length() <= 1) {
			n = Integer.parseInt(s);
			n %= 4;
			int ans = (int) (Math.pow(1, n) + Math.pow(2, n) + Math.pow(3, n) + Math.pow(4, n)) % 5;

			o.println(ans);
		} else {
			n = Integer.parseInt(s.substring(s.length() - 2));
			n %= 4;
			int ans = (int) (Math.pow(1, n) + Math.pow(2, n) + Math.pow(3, n) + Math.pow(4, n)) % 5;

			o.println(ans);

		}

		o.flush();
		o.close();
	}

}
