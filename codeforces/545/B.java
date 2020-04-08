import java.io.*;
import java.util.*;

public class Equidistant_String {

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
		String s1 = t.next(), s2 = t.next();
		int count = 0;
		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < s1.length(); ++i) {
			char ch1 = s1.charAt(i);
			char ch2 = s2.charAt(i);

			if (ch1 != ch2)
				count++;
		}

		if ((count & 1) == 1)
			o.println("impossible");
		else {
			byte change = 0;

			for (int i = 0; i < s1.length(); ++i) {
				char ch1 = s1.charAt(i);
				char ch2 = s2.charAt(i);

				if (ch1 == ch2) {
					ans.append(ch1);
				} else {
					if ((change & 1) == 1)
						ans.append(ch1);
					else
						ans.append(ch2);

					change = (byte) (1 - change);
				}
			}

			o.print(ans);
		}

		o.flush();
		o.close();
	}
}