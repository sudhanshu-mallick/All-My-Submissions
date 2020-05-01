import java.util.*;
import java.io.*;

public class Phonix_And_Distribution {

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
			int k = t.nextInt();
			String s = t.next();
			char te[] = s.toCharArray();
			StringBuilder sb = new StringBuilder();
			HashMap<Character, Integer> map = new HashMap<>();

			for (int i = 0; i < s.length(); ++i) {
				char ch = s.charAt(i);

				if (map.containsKey(ch))
					map.put(ch, map.get(ch) + 1);
				else
					map.put(ch, 1);
			}

			Arrays.sort(te);

			s = new String(te);

			if (map.get(s.charAt(0)) < k)
				o.println(s.charAt(k - 1));
			else {
				int i = k;

				sb.append(s.charAt(0));

				if (map.size() == 1) {
					int val = map.get(s.charAt(0));
					int p = val / k;

					while (p-- > 1)
						sb.append(s.charAt(0));

					if (val % k != 0)
						sb.append(s.charAt(0));
				} else if (map.size() == 2) {
					int val = map.get(s.charAt(0));

					if (val == k) {
						val = map.get(s.charAt(n - 1));
						int p = val / k;

						while (p-- > 0)
							sb.append(s.charAt(n - 1));

						if (val % k != 0)
							sb.append(s.charAt(n - 1));
					} else {
						while (i < n) {
							sb.append(s.charAt(i++));
						}
					}
				} else {
					while (i < n) {
						sb.append(s.charAt(i++));
					}
				}

				o.println(sb);
			}

		}

		o.flush();
		o.close();
	}
}