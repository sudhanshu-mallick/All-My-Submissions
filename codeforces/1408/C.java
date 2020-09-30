import java.util.*;
import java.io.*;

public class Discrete_Acceleration {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			double[] a = new double[n];
			long l = t.nextLong();

			for (int i = 0; i < n; ++i)
				a[i] = t.nextDouble();

			double time = 0;
			int i = 0, j = n - 1;
			long v1 = 1;
			long v2 = 1;
			double pos1 = 0;
			double pos2 = l;

			while (pos1 < pos2 && i <= j) {
				double d1 = a[i] - pos1;
				double d2 = pos2 - a[j];

				if (d1 * v2 > d2 * v1) {
					pos1 += (v1) * (d2 / v2);
					time += d2 / v2;
					++v2;
					pos2 = a[j--];
				} else {
					pos2 -= (v2) * (d1 / v1);
					time += d1 / v1;
					++v1;
					pos1 = a[i++];
				}
			}

			time += (pos2 - pos1) / (v1 + v2);

			o.println(time);
		}

		o.flush();
		o.close();
	}
}
