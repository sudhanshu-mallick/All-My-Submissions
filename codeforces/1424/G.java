
import java.util.*;
import java.io.*;

public class Years {

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
		long[][] a = new long[2 * n][2];

		for (int i = 0; i < n; ++i) {
			long l = t.nextLong();
			long r = t.nextLong();
			a[i * 2][0] = l;
			a[i * 2][1] = +1;
			a[i * 2 + 1][0] = r;
			a[i * 2 + 1][1] = -1;
		}

		Arrays.sort(a, (x, y) -> cmp(x, y));

		int cur = 0;
		int mcur = 0;
		long max = 0;

		for (int i = 0; i < a.length; ++i) {
			cur += a[i][1];

			if (cur > mcur) {
				mcur = cur;
				max = a[i][0];
			}
		}

		o.println(max + " " + mcur);
		o.flush();
		o.close();
	}

	private static int cmp(long[] a, long[] b) {
		if (a[0] < b[0])
			return -1;
		else if (a[0] > b[0])
			return +1;
		else if (a[1] < b[1])
			return -1;
		else if (a[1] > b[1])
			return +1;
		else
			return 0;
	}
}
