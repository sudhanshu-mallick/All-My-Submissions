import java.util.*;
import java.io.*;

public class Two_Teams_Composing {

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
			int dis = 0, max = 0;

			for (int i = 0; i < n; ++i)
				a[t.nextInt() - 1]++;

			for (int i = 0; i < n; ++i) {
				if (a[i] > 0)
					dis++;

				max = Math.max(max, a[i]);
			}

			if (dis < max)
				o.println(dis);
			else if (dis == max)
				o.println(dis - 1);
			else
				o.println(max);

		}

		o.flush();
		o.close();
	}
}