import java.util.*;
import java.io.*;

public class Binary_String_Recontruction {
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
			int x = t.nextInt();
			int y = t.nextInt();
			int z = t.nextInt();
			StringBuilder sb = new StringBuilder();
			int a = x, b = y, c = z;

			if ((b & 1) == 0) {
				if (b > 0)
					sb.append("1");

				b--;
				boolean f = true;

				while (a-- > -1)
					sb.append("0");

				while (b-- > 0) {
					if (f) {
						sb.append("1");
						f = false;
					} else {
						sb.append("0");
						f = true;
					}
				}

				while (c-- > 0)
					sb.append("1");
			} else {

				while (a-- > -1)
					sb.append("0");

				boolean f = true;

				while (b-- > 0) {
					if (f) {
						sb.append("1");
						f = false;
					} else {
						sb.append("0");
						f = true;
					}
				}

				while (c-- > 0)
					sb.append("1");
			}

			if (x == 0 && y == 0) {
				sb = new StringBuilder(sb.substring(1));
				sb.append("1");
			}

			o.println(sb);
		}

		o.flush();
		o.close();
	}
}