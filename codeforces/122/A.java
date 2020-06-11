import java.util.*;
import java.io.*;

public class Lucky_Division {

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
		int n = t.nextInt();
		boolean flag = false;

		for (int i = 4; i <= n; ++i) {
			if (n % i == 0) {
				String s = Integer.toString(i);
				boolean f = true;

				for (int j = 0; j < s.length(); ++j) {
					if (s.charAt(j) != '4' && s.charAt(j) != '7') {
						f = false;
						break;
					}
				}

				if (f) {
					flag = true;
					break;
				}
			}
		}

		if (flag)
			o.println("YES");
		else
			o.println("NO");

		o.flush();
		o.close();
	}
}
