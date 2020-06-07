import java.util.*;
import java.io.*;

public class Kuroni_And_Impossible_Calculations {

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
		int m = t.nextInt();
		long[] a = new long[n];

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		if (n > m)
			o.println("0");
		else {
			long ans = 1;

			for (int i = 0; i < n - 1; ++i) {
				for (int j = i + 1; j < n; ++j)
					ans = (ans * Math.abs(a[j] - a[i])) % (long) m;
			}

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}