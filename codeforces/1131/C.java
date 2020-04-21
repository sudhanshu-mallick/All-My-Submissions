import java.util.*;
import java.io.*;

public class Birthday {

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
		int[] b = new int[n];
		int x = 0, y = n - 1;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		Arrays.sort(a);

		for (int i = 0; i < n - 1; i += 2) {
			b[x++] = a[i];
			b[y--] = a[i + 1];
		}

		if ((n & 1) == 1)
			b[n / 2] = a[n - 1];

		for (int i = 0; i < n; ++i)
			o.print(b[i] + " ");

		o.flush();
		o.close();
	}
}