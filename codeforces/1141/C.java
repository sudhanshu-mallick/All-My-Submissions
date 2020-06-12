import java.util.*;
import java.io.*;

public class Polycarp_Restores_Permutation {
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
		int n = t.nextInt() - 1;
		long[] a = new long[n + 1];
		long[] b = new long[n];
		long min = 0, sum = 0;
		Set<Long> set = new HashSet<>();

		for (int i = 0; i < n; ++i) {
			b[i] = t.nextLong();
			sum += b[i];
			min = Math.min(min, sum);
		}

		a[0] = 1 - min;

		set.add(a[0]);

		for (int i = 1; i <= n; ++i) {
			a[i] = a[i - 1] + b[i - 1];

			set.add(a[i]);
		}

		boolean f = true;

		for (int i = 0; i < n + 1; ++i)
			if (a[i] < 1 || a[i] > n + 1)
				f = false;

		if (set.size() != n + 1)
			f = false;

		if (f)
			for (int i = 0; i <= n; ++i)
				o.print(a[i] + " ");
		else
			o.println("-1");

		o.flush();
		o.close();
	}
}