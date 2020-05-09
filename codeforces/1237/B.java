import java.util.*;
import java.io.*;

public class Balanced_Tunnel {

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
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		int count = 0, max = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt() - 1;

		for (int i = 0; i < n; ++i) {
			b[i] = t.nextInt() - 1;
			c[b[i]] = i;
		}

		for (int i = 0; i < n; ++i)
			d[i] = c[a[i]];

		for (int i = 0; i < n; ++i) {
			if (d[i] < max) {
				count++;
			} else
				max = d[i];
		}

		o.println(count);

		o.flush();
		o.close();
	}
}