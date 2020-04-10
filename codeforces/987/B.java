import java.util.*;
import java.io.*;

public class High_School_Become_Human {

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
		int x = t.nextInt(), y = t.nextInt();
		char ans = ' ';

		double d1 = y * Math.log(x);
		double d2 = x * Math.log(y);

		if (d1 > d2)
			ans = '>';
		else if (d2 > d1)
			ans = '<';
		else
			ans = '=';

		o.println(ans);

		o.flush();
		o.close();
	}
}