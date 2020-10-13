import java.util.*;
import java.io.*;

public class String_Deletion {

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
			char[] ch = t.next().toCharArray();
			char c = ch[0];
			int cnt = 1;
			List<Pair> one = new ArrayList<>();
			List<Pair> mto = new ArrayList<>();

			for (int i = 1; i < n; ++i) {
				if (c == ch[i])
					cnt++;
				else {
					if (cnt > 1)
						mto.add(new Pair(i - cnt, cnt));
					else
						one.add(new Pair(i - cnt, cnt));

					c = ch[i];
					cnt = 1;
				}
			}

			if (cnt > 1)
				mto.add(new Pair(n - cnt, cnt));
			else
				one.add(new Pair(n - cnt, cnt));

			int i = 0, j = 0;
			int turns = 0;

			while (i < one.size() && j < mto.size()) {
				Pair x = mto.get(j);
				Pair y = one.get(i);

				if (x.idx > y.idx) {
					if (x.cnt == 2) {
						one.set(i, new Pair(j, 1));

						turns++;
						++j;
					} else {
						++i;
						turns++;

						mto.set(j, new Pair(x.idx, x.cnt - 1));
					}

				} else {
					turns++;
					++j;
				}
			}

			turns += (one.size() - i + 1) >> 1;

			if (j < mto.size())
				turns += mto.size() - j;

			o.println(turns);
		}

		o.flush();
		o.close();
	}

	static class Pair {
		int idx;
		int cnt;

		Pair(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
}