import java.util.*;
import java.io.*;

public class Gourmet_Cat {

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
		long a = t.nextLong();
		long b = t.nextLong();
		long c = t.nextLong();
		long d = Math.min(a / 3, Math.min(b / 2, c / 2));
		a = a - d * 3;
		b = b - d * 2;
		c = c - d * 2;
		long count = 7 * d;
		char ch[] = { 'a', 'b', 'c', 'a', 'c', 'b', 'a' };
		long max = 0;

		for (int j = 0; j < 7; ++j) {
			int cnt = 0;
			int i = j;
			long x = a, y = b, z = c;

			while (cnt < 7) {
				if (x > 0 && ch[i] == 'a')
					x--;
				else if (y > 0 && ch[i] == 'b')
					y--;
				else if (z > 0 && ch[i] == 'c')
					z--;
				else
					break;

				cnt++;
				i = (i + 1) % 7;
			}

			max = Math.max(max, cnt);
		}

		o.println(count + max);

		o.flush();
		o.close();
	}
}