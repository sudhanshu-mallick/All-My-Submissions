import java.util.*;
import java.io.*;

public class Vacation {

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
		int[] a = new int[n];
		int cur = 0, count = 0;

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();

			if (a[i] == 0) {
				cur = 0;
				count++;
			} else if (a[i] == 3) {
				cur = 3 - cur;
			} else if (a[i] == 2) {
				if (cur == 2) {
					cur = 0;
					count++;
				} else {
					cur = 2;
				}
			} else {
				if (cur == 1) {
					cur = 0;
					count++;
				} else {
					cur = 1;
				}
			}
		}

		o.println(count);

		o.flush();
		o.close();
	}
}