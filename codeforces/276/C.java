import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Little_Girl_And_Maximum_Sum {

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
		Integer[] a = new Integer[n];
		Long[] idx = new Long[n + 1];
		int q = t.nextInt();
		long ans = 0;

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		Arrays.fill(idx, 0l);

		while (q-- > 0) {
			int l = t.nextInt();
			int r = t.nextInt();

			idx[l - 1]++;
			idx[r]--;
		}

		for (int i = 1; i <= n; i++)
			idx[i] += idx[i - 1];

		Arrays.sort(a);
		Arrays.sort(idx);

		for (int i = 0; i < n; i++)
			ans += (long) (a[i] * idx[i + 1]);

		o.println(ans);
		o.flush();
		o.close();

	}

}
