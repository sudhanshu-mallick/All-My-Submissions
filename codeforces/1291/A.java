import java.util.*;
import java.io.*;

public class Even_But_Not_Even {

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
			char ch[] = t.next().toCharArray();
			int oddCount = 0;

			for (int i = 0; i < n; ++i) {
				if (((ch[i] - '0') & 1) == 1) {
					++oddCount;
				}
			}

			if (oddCount > 1) {
				int i = 0;
				oddCount = 0;

				while (oddCount <= 1) {
					o.print(ch[i]);

					if (((ch[i] - '0') & 1) == 1)
						++oddCount;

					++i;
				}

				o.println();
			} else {
				o.println("-1");
			}
		}

		o.flush();
		o.close();
	}
}
