import java.util.*;
import java.io.*;

public class Sages_Birthday {

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
		int res = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		Arrays.sort(a);

		int k = 0;

		for (int i = 1; i < n; i += 2) {
			b[i] = a[k++];
		}
		for (int i = 0; i < n; i += 2) {
			b[i] = a[k++];
		}
		for (int i = 1; i < n - 1; i++)
			if (b[i] < b[i - 1] && b[i] < b[i + 1])
				res++;

		o.println(res);

		for (int i = 0; i < n; i++) {
			o.print(b[i] + " ");
		}

		o.flush();
		o.close();
	}
}