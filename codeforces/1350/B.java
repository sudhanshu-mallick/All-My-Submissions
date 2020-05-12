import java.util.*;
import java.io.*;

public class Orac_And_Model {

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
			Pair a[] = new Pair[n + 1];
			int[] c = new int[n + 1];

			for (int i = 1; i <= n; ++i)
				a[i] = new Pair(i, t.nextInt());

//			Arrays.sort(a, (Pair x, Pair y) -> (x.s - y.s) != 0 ? x.s - y.s : x.i - y.i);
//
//			for (int i = n - 1; i >= 0; --i) {
//				int idx = a[i].i;
//				int si = a[i].s;
//				int k = 1;
//				
//			}

			for (int i = n / 2; i >= 1; --i) {
				int idx = a[i].i;
				int k = 2;

				while (idx * k <= n) {
					int j = idx * k;
					k++;

					if (a[j].s > a[idx].s)
						c[idx] = Math.max(c[idx], c[j] + 1);
				}
			}

			int max = 0;

			for (int i = 1; i <= n; ++i)
				max = Math.max(c[i], max);

			o.println(max + 1);

		}

		o.flush();
		o.close();
	}

}

class Pair {
	int i;
	int s;

	Pair(int ii, int ss) {
		i = ii;
		s = ss;
	}
}