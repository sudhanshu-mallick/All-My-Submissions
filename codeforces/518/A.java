import java.util.*;
import java.io.*;

public class Vitaly_And_Strings {

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
		char[] one = t.next().toCharArray();
		char[] two = t.next().toCharArray();
		char[] ans = one.clone();
		int i = one.length - 1;

		while (i >= 0 && one[i] == 'z') {
			ans[i] = 'a';
			--i;
		}

		if (i >= 0)
			ans[i] = (char) (one[i] + 1);

		String a = new String(ans);

		if (a.compareTo(new String(one)) <= 0 || a.compareTo(new String(two)) >= 0)
			o.println("No such string");
		else
			o.println(a);

		o.flush();
		o.close();
	}
}