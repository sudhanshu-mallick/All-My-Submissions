import java.util.*;
import java.io.*;

public class Alternating_Subsequences {

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
			long[] a = new long[n];
			long sum = 0, flag = 0, max = Integer.MIN_VALUE;
			ArrayList<Integer> idx = new ArrayList<>();

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong();
			}

			for (int i = 1; i < n; ++i) {
				if (a[i] * a[i - 1] < 0)
					idx.add(i - 1);
			}

			for (int i = 0; i < idx.size(); ++i) {
				int p = idx.get(i);
				max = Integer.MIN_VALUE;
				int si = i == 0 ? 0 : idx.get(i - 1) + 1;

				for (int j = si; j <= p; ++j) {
					max = Math.max(max, a[j]);
				}

				sum += max;
			}

			int si = idx.size() == 0 ? 0 : idx.get(idx.size() - 1) + 1;
			max = Integer.MIN_VALUE;

			for (int i = si; i < n; ++i)
				max = Math.max(max, a[i]);

			sum += max;

			o.println(sum);

		}

		o.flush();
		o.close();
	}
}