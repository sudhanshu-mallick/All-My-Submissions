import java.util.*;
import java.io.*;

public class Approximating_A_Constant_Value {

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

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		int j = 0, i = 1, count = 2;
		int max = j, min = j;

		while (i < n) {
			if (a[i] >= a[max])
				max = i;

			if (a[i] <= a[min])
				min = i;

			if (a[max] - a[min] > 1) {
				count = Math.max(i - j, count);

				if (i == n - 1) {
					break;
				}

				if (min < max) {
					j = ++min;
				}

				if (min > max) {
					j = ++max;
				}
			} else {
				i++;
			}
		}

		o.println(Math.max(i - j, count));

		o.flush();
		o.close();
	}
}