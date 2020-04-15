import java.util.*;
import java.io.*;

public class From_S_To_T {

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
			String s = t.next();
			String q = t.next();
			String p = t.next();
			HashMap<Character, Integer> map = new HashMap<>();
			int idx = 0, flag = 1;

			for (int i = 0; i < s.length(); ++i) {
				char ch = s.charAt(i);

				while (idx < q.length() && ch != q.charAt(idx)) {
					char c = q.charAt(idx);

					if (map.containsKey(c)) {
						map.put(c, map.get(c) + 1);
					} else
						map.put(c, 1);

					idx++;
				}

				if (idx == q.length()) {
					flag = 0;
					break;
				}

				idx++;
			}

			while (idx < q.length()) {
				char c = q.charAt(idx);

				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else
					map.put(c, 1);

				idx++;
			}

			if ((flag & 1) == 0)
				o.println("NO");
			else {
				HashMap<Character, Integer> m = new HashMap<>();

				for (int i = 0; i < p.length(); ++i) {
					char c = p.charAt(i);

					if (m.containsKey(c)) {
						m.put(c, m.get(c) + 1);
					} else {
						m.put(c, 1);
					}
				}

				for (Map.Entry<Character, Integer> entry : map.entrySet()) {
					char ch = entry.getKey();

					if (!m.containsKey(ch)) {
						flag = 0;
						break;
					}

					if (map.get(ch) > m.get(ch)) {
						flag = 0;
						break;
					}
				}

				if ((flag & 1) == 0)
					o.println("NO");
				else
					o.println("YES");
			}
		}

		o.flush();
		o.close();
	}
}