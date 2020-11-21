import java.util.*;
import java.io.*;

public class String_Equality {

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
			char a[] = t.next().toCharArray();
			char[] b = t.next().toCharArray();
			int[] ca = new int[26];
			int[] cb = new int[26];
			boolean flag = true;

			for (char ch : a) {
				ca[ch - 'a']++;
			}

			for (char ch : b) {
				if (ca[ch - 'a'] > 0)
					ca[ch - 'a']--;
				else
					cb[ch - 'a']++;
			}

			int i = 0, j = 0;

			while (i < 26 && j < 26) {
				while (j < 26 && cb[j] == 0)
					++j;

				if (j == 26)
					break;

				while (i < 26 && ca[i] == 0) {
					++i;
				}

				if (i >= j) {
					flag = false;
					break;
				}

				while (cb[j] >= k) {
					if (i >= j) {
						flag = false;
						break;
					}

					if (ca[i] == 0) {
						++i;
					} else if (ca[i] < k) {
						flag = false;
						break;
					} else {
						ca[i] -= k;
						cb[j] -= k;
					}
				}

				if (cb[j] > 0) {
					flag = false;
					break;
				}

				if (!flag)
					break;
			}

			if (flag)
				o.println("Yes");
			else
				o.println("No");
		}

		o.flush();
		o.close();
	}
}