import java.util.*;
import java.io.*;

public class Hilberts_Hotel {
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
			boolean ans = true;
			boolean vis[] = new boolean[n];

			for (int i = 0; i < n; ++i) {
				long x = t.nextLong();

				if (x < 0)
					x = (i + (Math.abs(x) % n == 0 ? 0 : n - Math.abs(x) % n)) % n;
				else
					x = (i + x % n) % n;

				if (!vis[(int) x])
					vis[(int) x] = true;
				else
					ans = false;
			}

			if (ans)
				o.println("YES");
			else
				o.println("NO");
		}

		o.flush();
		o.close();
	}
}