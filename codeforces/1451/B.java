import java.util.*;
import java.io.*;

public class Non_Substring_Subequence {

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
			int q = t.nextInt();
			char ch[] = t.next().toCharArray();
			int preZero[] = new int[n];
			int preOne[] = new int[n];
			int postZero[] = new int[n];
			int postOne[] = new int[n];

			for (int i = 1; i < n; ++i) {
				int v1 = ch[i - 1] - '0';
				int v2 = ch[n - i] - '0';

				if (v1 == 0)
					preZero[i] = 1;
				else
					preOne[i] = 1;

				if (v2 == 0)
					postZero[n - i - 1] = 1;
				else
					postOne[n - i - 1] = 1;

				preZero[i] += preZero[i - 1];
				preOne[i] += preOne[i - 1];
				postOne[n - i - 1] += postOne[n - i];
				postZero[n - i - 1] += postZero[n - i];
			}

			while (q-- > 0) {
				int l = t.nextInt() - 1;
				int r = t.nextInt() - 1;
				boolean flag = false;

				if (ch[l] == '0' && preZero[l] > 0) {
					flag = true;
				} else if (ch[l] == '1' && preOne[l] > 0) {
					flag = true;
				} else if (ch[r] == '0' && postZero[r] > 0) {
					flag = true;
				} else if (ch[r] == '1' && postOne[r] > 0) {
					flag = true;
				}

				if (flag)
					o.println("YES");
				else
					o.println("NO");
			}
		}

		o.flush();
		o.close();
	}
}