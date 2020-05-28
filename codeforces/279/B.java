import java.util.*;
import java.io.*;

public class Books {

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
		long time = t.nextLong();
		long a[] = new long[n];
		long cur = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		int i = 0, j = 0, max = 0;

		while (i < n) {
			cur += a[i];

			if (cur <= time) {
				max = Math.max(i - j + 1, max);
			} else {
				while (cur > time)
					cur -= a[j++];
			}

			i++;
		}

		o.println(max);

		o.flush();
		o.close();
	}
}