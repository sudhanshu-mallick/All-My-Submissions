import java.util.*;
import java.io.*;

public class Boxers {

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

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		Arrays.sort(a);

		int cur = a[0] > 1 ? a[0] - 1 : a[0];
		int count = 1;

		for (int i = 1; i < n; ++i) {
			if (a[i] == cur + 1) {
				count++;
				cur = a[i];
			} else if (a[i] == cur) {
				count++;
				cur = a[i] + 1;
			} else if (a[i] > cur) {
				cur = a[i] - 1;
				count++;
			}
		}

		o.println(count);

		o.flush();
		o.close();
	}
}