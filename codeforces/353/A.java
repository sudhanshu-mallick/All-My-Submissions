import java.io.*;
import java.util.*;

public class Domino {

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
		int test = t.nextInt(), ev = 0, od = 0, odd = 0, cost = -1;
		int suml = 0, sumr = 0;

		for (int i = 0; i < test; i++) {
			int x = t.nextInt();
			int y = t.nextInt();
			suml += x;
			sumr += y;
			int r1 = (x & 1);
			int r2 = (y & 1);

			if (r1 == 0 && r2 == 1)
				ev++;
			else if (r1 == 1 && r2 == 0)
				od++;
		}

		suml = suml & 1;
		sumr = sumr & 1;

		if (suml == 0 && sumr == 0)
			cost = 0;
		else if (suml == 1 && sumr == 1) {
			if (ev > 0 || od > 0)
				cost = 1;
		}

		o.println(cost);

		o.flush();
		o.close();
	}
}