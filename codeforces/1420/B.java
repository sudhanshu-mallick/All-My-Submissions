import java.util.*;
import java.io.*;

public class Rock_And_Lever {

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
			int[] a = new int[n];
			long cur = 1;
			long ans = 0;
			Map<Integer, Long> map = new HashMap<>();

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextInt();
				int v = 0;

				while (a[i] > 0) {
					v++;
					a[i] = a[i] >> 1;
				}

				long val = map.getOrDefault(v, 0l);

				map.put(v, val + 1);
			}

			for (Map.Entry<Integer, Long> m : map.entrySet()) {
				long v = m.getValue();
				ans += ((v - 1) * v) / 2;
			}

			o.println(ans);

		}

		o.flush();
		o.close();
	}
}