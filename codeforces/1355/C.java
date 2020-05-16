import java.util.*;
import java.io.*;

public class Count_Triangles {

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
		long w = t.nextLong();
		long x = t.nextLong();
		long y = t.nextLong();
		long z = t.nextLong();
		long count = 0;

		for (long i = w; i <= x; ++i) {
			long si = x, ei = y;
			long mid = (si + ei) / 2;
			long res = y;

			while (si <= ei) {
				if (i + mid <= y)
					si = mid + 1;
				else {
					res = mid;
					ei = mid - 1;
				}

				mid = (si + ei) / 2;
			}

			// System.out.println(i + " " + res);

			long mi = z - (res + i) + 1;
			long mini = Math.min(y - res + 1, mi);

			if (mini >= 0)
				count += mini * (res + i - y) + mini * (mini - 1) / 2;

			if (mini >= 0)
				mini = y - res + 1 - mini;
			else
				mini = y - res + 1;

			if (mini > 0)
				count += (z + 1 - y) * mini;
		}

		o.println(count);

		o.flush();
		o.close();
	}
}
