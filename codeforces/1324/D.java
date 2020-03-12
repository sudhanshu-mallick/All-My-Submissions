import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Pair_Of_Topics {

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
		long a[] = new long[n];
		long b[] = new long[n];
		Long d[] = new Long[n];
		long count = 0;

		for (int i = 0; i < n; i++)
			a[i] = t.nextLong();

		for (int i = 0; i < n; i++)
			b[i] = t.nextLong();

		for (int i = 0; i < n; i++)
			d[i] = a[i] - b[i];

		Arrays.sort(d);

		for (int i = 0; i < n; i++) {
			long k = 0 - d[i];
			count += bs(k, d, i + 1);
		}

		o.println(count);

		o.flush();
		o.close();
	}

	static int bs(long k, Long d[], int i) {
		int n = d.length;
		int si = i;
		int ei = n - 1;
		int ans = n ;

		while (si <= ei) {
			int mid = si + (ei - si) / 2;

			if (d[mid] > k) {
				ans = mid;
				ei = mid - 1;
			} else
				si = mid + 1;
		}

		return (n - ans);
	}

}
