import java.util.*;
import java.io.*;

public class Big_Vova {

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
			Set<Integer> set = new HashSet<>();
			int max = 0;
			int[] a = new int[n];
			int idx = 0;

			for (int i = 0; i < n; ++i) {
				int v = t.nextInt();
				a[i] = v;

				if (max < v) {
					max = v;
					idx = i;
				}

				set.add(i);
			}

			o.print(max + " ");
			set.remove(idx);

			int cur = max;

			while (set.size() > 0) {
				max = 0;
				idx = -1;

				for (int i : set) {
					int gcd = gcd(Math.min(a[i], cur), Math.max(a[i], cur));

					if (gcd > max) {
						max = gcd;
						idx = i;
					}
				}
				if (max == 1) {
					break;
				}

				cur = max;

				o.print(a[idx] + " ");
				set.remove(idx);
			}

			for (int i : set)
				o.print(a[i] + " ");

			o.println();
		}

		o.flush();
		o.close();
	}

	private static int gcd(int a, int b) {
		if (a == 0)
			return b;

		return gcd(b % a, a);
	}
}