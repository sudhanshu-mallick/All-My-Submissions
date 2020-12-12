import java.util.*;
import java.io.*;

public class Competitive_Programmer {

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
			char ch[] = t.next().toCharArray();
			boolean zero = false;
			boolean even = false;
			int sum = 0;

			for (int i = 0; i < ch.length; ++i) {
				int val = ch[i] - '0';

				if (val == 0) {
					if (zero)
						even = true;
					else
						zero = true;
				} else if ((val & 1) == 0) {
					even = true;
				}

				sum += val;
			}

			if (sum % 3 == 0 && zero && even)
				o.println("red");
			else
				o.println("cyan");
		}

		o.flush();
		o.close();
	}
}