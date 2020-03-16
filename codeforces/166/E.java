import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Tetrahedron {

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
		long a = 0, b = 0, c = 0, d = 0, fa = 0, fb = 0, fc = 0, fd = 1;
		long mod = 1000000007;

		for (int i = 0; i < n; i++) {
			a = (fb + fc + fd) % mod;
			b = (fa + fc + fd) % mod;
			c = (fa + fb + fd) % mod;
			d = (fa + fb + fc) % mod;
			fa = a;
			fb = b;
			fc = c;
			fd = d;
		}

		o.println(d);
		o.flush();
		o.close();
	}

}
