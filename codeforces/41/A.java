import java.util.*;
import java.io.*;

public class Translation {

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
		boolean f = true;

		if (s1.length() != s2.length())
			f = false;
		else {
			for (int i = 0, j = s2.length() - 1; j >= 0; i++, j--) {
				if (s1.charAt(i) != s2.charAt(j))
					f = false;
			}
		}

		if (f)
			o.println("YES");
		else
			o.println("NO");

		o.flush();
		o.close();
	}
}