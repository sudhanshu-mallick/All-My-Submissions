import java.util.*;
import java.io.*;

public class Sifid_And_Strange_Subsequences {

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

	public static void shuffle(long[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(long[] a, int i, int j) {
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			long[] a = new long[n];
			int idxZero = -1, idxPositive = -1, idxNegative = -1, ans = 1;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextLong();

			shuffle(a);

			for (int i = 0; i < n; ++i) {
				if (a[i] < 0)
					idxNegative = i;
				else if (a[i] == 0)
					idxZero = i;
				else {
					idxPositive = i;
					break;
				}
			}

//			System.out.println(idxNegative);

			ans = Math.max(ans, idxNegative + 1);
			ans = Math.max(ans, idxZero + 1);
			int count = 1;

			if (idxPositive > 0) {
				int i = idxPositive - 1;
				++count;
				long cur = a[i];

				while (i >= 0) {
					if (cur - a[i] >= a[idxPositive]) {
						++count;
						cur = a[i];
					}

					--i;
				}
			}

			ans = Math.max(ans, count);

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}
