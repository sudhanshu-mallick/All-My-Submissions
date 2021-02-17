import java.util.*;
import java.io.*;

public class Accidental_Victory {

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
			long[] b = new long[n];
			List<Integer> ans = new ArrayList<>();

			for (int i = 0; i < n; ++i) {
				a[i] = b[i] = t.nextLong();
			}

			shuffle(b);

			long ele = b[n - 1];

			for (int i = 1; i < n; ++i)
				b[i] += b[i - 1];

			for (int i = n - 2; i >= 0; --i) {
				if ((b[i] << 1) >= b[i + 1])
					ele = b[i] - (i == 0 ? 0 : b[i - 1]);
				else
					break;
			}

			for (int i = 0; i < n; ++i) {
				if (a[i] >= ele)
					ans.add(i + 1);
			}

			o.println(ans.size());

			for (int v : ans)
				o.print(v + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}