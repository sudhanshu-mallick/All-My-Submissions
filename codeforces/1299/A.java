import java.util.*;
import java.io.*;

public class Anu_Has_A_Function {

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
		long[] a = new long[n];

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		if (n == 1) {
			o.println(a[0]);
			o.close();
			return;
		}

		long[] l = new long[n];
		long[] r = new long[n];
		l[0] = ~a[0];
		r[n - 1] = ~a[n - 1];

		for (int i = 1; i < n; i++)
			l[i] = l[i - 1] & (~a[i]);

		for (int i = n - 2; i >= 0; i--)
			r[i] = r[i + 1] & (~a[i]);

		long max = -1;
		int idx = -1;

		for (int i = 0; i < n; i++) {
			long temp = a[i];

			if (i == 0)
				temp &= r[1];
			else if (i == n - 1)
				temp &= l[n - 2];
			else
				temp &= r[i + 1] & l[i - 1];

			if (max < temp) {
				idx = i;
				max = temp;
			}
		}

		o.print(a[idx] + " ");

		for (int i = 0; i < n; i++) {
			if (i != idx)
				o.print(a[i] + " ");
		}

		o.flush();
		o.close();
	}
}