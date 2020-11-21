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

			while (q-- > 0) {
				int l = t.nextInt() - 1;
				int r = t.nextInt() - 1;
				int k = l;
				boolean flag = false;
				boolean f = false;
				int i = 0;

				while (k < r) {
					if (ch[i] == ch[k]) {
						++k;
					} else if (k > l) {
						f = true;
					}

					++i;
				}

				if (!f)
					++i;

				while (i < n) {
					if (ch[i] == ch[r]) {
						flag = true;
						break;
					}

					++i;
				}

				if (flag)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}

		o.flush();
		o.close();
	}
}