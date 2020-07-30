import java.util.*;
import java.io.*;

public class sample {

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
		int m = t.nextInt();
		int n = t.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		Arrays.sort(a);

		int min = Integer.MAX_VALUE;
		int i = 0;

		while (true) {
			int j = i + m - 1;

			if (j >= n)
				break;

			min = Math.min(a[j] - a[i], min);
			++i;
		}

		o.println(min);

		o.flush();
		o.close();
	}
}
