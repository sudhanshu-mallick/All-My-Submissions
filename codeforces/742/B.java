
import java.util.*;
import java.io.*;

public class Arpas_Obvious_Problem_And_Mehrdads_Obvious_Solution {

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
		int x = t.nextInt();
		long count = 0;
		long[] a = new long[100000];

		for (int i = 0; i < n; ++i) {
			a[t.nextInt() - 1]++;
		}

		for (int i = 0; i < 100000; ++i) {
			long p = i + 1;
			long q = x ^ p;

			if (p * q > 0 && p <= 100000 && q <= 100000) {
				if (p != q) {
					count += a[(int) p - 1] * a[(int) q - 1];
					a[(int) p - 1] = a[(int) q - 1] = 0;
				} else {
					count += (a[(int) p - 1] - 1) * (a[(int) p - 1]) / 2;
					a[(int) p - 1] = 0;
				}
			}
		}

		o.println(count);
		o.flush();
		o.close();
	}
}