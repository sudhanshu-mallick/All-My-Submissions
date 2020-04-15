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
		int[] c = new int[100];
		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();

			if (i != 0)
				b[i] += b[i - 1] + a[i - 1];
		}

		for (int i = 0; i < n; ++i) {
			if (b[i] + a[i] <= M)
				ans.append(0 + " ");
			else {
				int sum = b[i];
				int idx = 99;
				int count = 0;

				while (sum + a[i] > M) {
					if (c[idx] >= 1) {
						int p = (idx + 1) * c[idx];

						if (p >= sum + a[i] - M) {
							count += (sum + a[i] - M + idx) / (idx + 1);
							break;
						}

						count += c[idx];
						sum -= p;

					}

					idx--;
				}

				ans.append(count + " ");
			}

			c[a[i] - 1]++;
		}

		o.println(ans);

		o.flush();
		o.close();
	}
}