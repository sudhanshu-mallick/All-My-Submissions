import java.util.*;
import java.io.*;

public class Exams_In_Bersu {

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
		int M = t.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();

			if (i != 0)
				b[i] += b[i - 1] + a[i];
			else
				b[i] = a[i];
		}

		for (int i = 0; i < n; ++i) {
			if (b[i] <= M) {
				ans.append(0 + " ");
			} else {
				Integer[] c = new Integer[i];
				int sum = b[i];
				int k = i - 1;

				for (int j = 0; j < i; ++j)
					c[j] = a[j];

				Arrays.sort(c);

				while (sum > M) {
					sum -= c[k--];
				}

				ans.append((i - k - 1) + " ");

			}
		}

		o.println(ans);

		o.flush();
		o.close();
	}
}