import java.util.*;
import java.io.*;

public class Couting_Kangaroos_Is_Fun {

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
		Integer[] a = new Integer[n];
		int idx = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		Arrays.sort(a);
		int cur = n / 2;
		int ans = n;

		for (int i = 0; i < n / 2; ++i) {
			while (true) {
				if (a[i].intValue() * 2 <= a[cur]) {
					ans--;
					cur++;
					break;
				} else {
					cur++;
				}

				if (cur == n) {
					break;
				}
			}

			if (cur == n)
				break;
		}

		o.println(ans);
		o.flush();
		o.close();
	}
}