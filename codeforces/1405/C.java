
import java.util.*;
import java.io.*;

public class Balanced_BitString {

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
			char ch[] = t.next().toCharArray();
			char cur = ch[0];
			int one = 0;
			int zero = 0;
			boolean flag = true;
			int cnt = 1;

			for (int i = 1; i < n; ++i) {
				if (ch[i] == cur) {
					cnt++;
				} else {
					if (cur != '?') {
						if (cnt > k / 2) {
							flag = false;
							break;
						}
					}

					cur = ch[i];
					cnt = 1;
				}
			}

			if (cur != '?' && cnt > k / 2)
				flag = false;

			if (flag) {
				for (int i = 0; i < k; ++i) {
					char c = ch[i];
					int j = i + k;

					while (j < n) {
						if (c == '?')
							c = ch[j];
						else if (ch[j] != '?' && ch[j] != c) {
							flag = false;
							break;
						}

						j += k;
					}

					if (!flag)
						break;

					j = i;

					while (j < n) {
						ch[j] = c;
						j += k;
					}
				}

				for (int i = 0; i < n; ++i) {
					if (ch[i] == '1')
						one++;

					if (ch[i] == '0')
						zero++;

					if (i >= k - 1) {
						if (one > k / 2 || zero > k / 2) {
							flag = false;
						}

						if (ch[i - k + 1] == '1')
							one--;

						if (ch[i - k + 1] == '0')
							zero--;
					}
				}

				if (flag)
					o.println("YES");
				else
					o.println("NO");

			} else {
				o.println("NO");
			}
		}

		o.flush();
		o.close();
	}
}