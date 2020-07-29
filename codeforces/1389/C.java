
import java.util.*;
import java.io.*;

public class Good_String {

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
			List<Integer>[] cnt = new ArrayList[10];
			int max = 0;

			for (int i = 0; i < 10; ++i)
				cnt[i] = new ArrayList<>();

			for (int i = 0; i < s.length(); ++i) {
				int ch = s.charAt(i) - '0';
				cnt[ch].add(i);
			}

			for (int i = 0; i < 10; ++i)
				max = Math.max(cnt[i].size(), max);

			for (int i = 0; i < 10; ++i)
				cnt[i].add(Integer.MAX_VALUE);

			for (int i = 0; i < 10; ++i) {

				if (cnt[i].size() == 1)
					continue;

				for (int j = i + 1; j < 10; ++j) {
					if (cnt[j].size() == 1)
						continue;

					int cmax = 0;
					int x = 0;
					int y = 0;
					int choice = cnt[i].get(x) > cnt[j].get(y) ? 1 : 0;

					while (x < cnt[i].size() && y < cnt[j].size()) {
						if (choice == 1) {
							if (cnt[i].get(x) > cnt[j].get(y)) {
								cmax++;
								++y;
								choice = 0;
							} else {
								++x;
							}
						} else {
							if (cnt[i].get(x) < cnt[j].get(y)) {
								cmax++;
								choice = 1;
								++x;
							} else {
								++y;
							}
						}
					}

					cmax = cmax - (cmax & 1);
					max = Math.max(cmax, max);
				}
			}

			o.println(s.length() - max);

		}

		o.flush();
		o.close();
	}
}
