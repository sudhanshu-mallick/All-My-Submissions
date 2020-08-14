import java.util.*;
import java.io.*;

public class Good_Subarrays {

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
			char ch[] = t.next().toCharArray();
			Map<Long, Long> map = new HashMap<>();
			long cs = 0;
			long cnt = 0;

			map.put(1l, 1l);

			for (int i = 0; i < n; ++i) {
				cs += (long)(ch[i] - '0');

				long req = cs - i;
				long v = map.getOrDefault(req, 0l);
				cnt += v;

				map.put(req, v + 1);
			}

			o.println(cnt);

		}

		o.flush();
		o.close();
	}
}