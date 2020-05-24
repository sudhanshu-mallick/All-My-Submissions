import java.io.*;
import java.util.*;

public class Similar_Pairs {

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
			int[] a = new int[n];
			int even = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();

				if ((a[i] & 1) == 0)
					even++;
			}

			if ((even & 1) == 0)
				o.println("YES");
			else {
				Arrays.sort(a);

				boolean f = false;

				for (int i = 0; i < n - 1; ++i) {
					if (a[i + 1] == a[i] + 1) {
						f = true;
						break;
					}
				}

				if (f)
					o.println("YES");
				else
					o.println("NO");
			}
		}

		o.flush();
		o.close();
	}
}