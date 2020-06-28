import java.util.*;
import java.io.*;

public class Zero_Remainder_Array {

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
		StringBuilder sb = new StringBuilder();

		while (test-- > 0) {
			int n = t.nextInt();
			long k = t.nextLong();
			Map<Long, Long> map = new HashMap<>();
			long max = 0;

			for (int i = 0; i < n; ++i) {
				long p = t.nextLong() % k;
				long x = p == 0 ? 0 : k - p;
				long val = map.get(x) == null ? 0 : map.get(x);

				if (x != 0)
					map.put(x, val + 1);
			}

			for (Map.Entry<Long, Long> m : map.entrySet()) {
				long key = m.getKey();
				long val = m.getValue();
				max = Math.max(max, key + (val - 1) * k + 1);
			}

			sb.append(max + "\n");
		}

		o.println(sb);
		o.flush();
		o.close();
	}
}
