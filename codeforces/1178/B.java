
import java.util.*;
import java.io.*;

public class Wow_Factor {
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
		String s = t.next();
		long count = 0, v = 0, z = 0;

		for (int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);

			if (ch == 'o')
				z += v;
			else {
				if (i > 0 && s.charAt(i - 1) == 'v') {
					v++;
					count += z;
				}
			}
		}

		o.println(count);

		o.flush();
		o.close();
	}

}