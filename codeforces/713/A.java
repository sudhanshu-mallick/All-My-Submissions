import java.util.*;
import java.io.*;

public class Sonya_And_Queries {

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
		HashMap<Long, Integer> map = new HashMap<>();

		while (test-- > 0) {
			String q = t.next();

			if (q.equals("+")) {
				String s = t.next();
				StringBuilder sb = new StringBuilder();

				for (int i = 0; i < s.length(); ++i) {
					char ch = s.charAt(i);

					if (((ch - '0') & 1) == 1)
						sb.append('1');
					else
						sb.append('0');
				}

				long val = Long.parseLong(sb.toString());

				if (map.containsKey(val))
					map.put(val, map.get(val) + 1);
				else
					map.put(val, 1);
			} else if (q.equals("-")) {
				String s = t.next();
				StringBuilder sb = new StringBuilder();

				for (int i = 0; i < s.length(); ++i) {
					char ch = s.charAt(i);

					if (((ch - '0') & 1) == 1)
						sb.append('1');
					else
						sb.append('0');
				}

				long val = Long.parseLong(sb.toString());

				if (map.get(val) > 1)
					map.put(val, map.get(val) - 1);
				else
					map.remove(val);
			} else {
				String p = t.next();

				o.println(map.get(Long.parseLong(p)) != null ? map.get(Long.parseLong(p)) : 0);
			}

		}

		o.flush();
		o.close();
	}
}