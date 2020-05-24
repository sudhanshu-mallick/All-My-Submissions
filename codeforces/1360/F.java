import java.io.*;
import java.util.*;

public class Spy_String {

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
			int m = t.nextInt();
			HashSet<Character>[] set = new HashSet[m];
			StringBuilder ans = new StringBuilder();
			String[] a = new String[n];

			for (int i = 0; i < m; ++i)
				set[i] = new HashSet<>();

			for (int i = 0; i < n; ++i) {
				a[i] = t.next();

				for (int j = 0; j < m; ++j)
					set[j].add(a[i].charAt(j));
			}

			for (int i = 0; i < m; ++i) {
				if (set[i].size() == 1) {
					ans.append(a[0].charAt(i));
				} else
					break;
			}

			int id = ans.length();

			if (id >= m - 1) {
				if (id == m)
					o.println(ans);
				else {
					o.print(ans);
					o.println(a[0].charAt(m - 1));
				}
			} else {
				boolean f = false;

				for (int i = 0; i < n; ++i) {
					HashSet<String> map = new HashSet<>();
					String s = "";
					char ch = a[i].charAt(id);

					for (int j = 0; j < n; ++j) {
						if (a[j].charAt(id) != ch) {
							map.add(a[j].substring(id + 1));
							s = a[j].substring(id + 1);

							if (map.size() > 1)
								break;
						}
					}

					if (map.size() == 1) {
						boolean r = true;

						for (int j = 0; j < n; ++j) {
							int count = 0;

							if (a[j].charAt(id) == ch) {
								for (int k = id + 1; k < m; ++k) {
									if (s.charAt(k - id - 1) != a[j].charAt(k)) {
										count++;
									}
								}
							}

							if (count >= 2) {
								r = false;
								break;
							}
						}

						if (r) {
							f = true;

							ans.append(ch);
							ans.append(s);
							break;
						}
					}

					if (f)
						break;
				}

				if (f)
					o.println(ans);
				else {
					o.println("-1");
				}
			}

		}

		o.flush();
		o.close();
	}
}