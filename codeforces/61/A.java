import java.util.*;
import java.io.*;

public class Ultra_Fast_Mathematician {

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
		String s1 = t.next();
		String s2 = t.next();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s1.length(); ++i) {
			int v = (s1.charAt(i) - '0') ^ (s2.charAt(i) - '0');

			sb.append(v);
		}

		o.println(sb);

		o.flush();
		o.close();
	}
}