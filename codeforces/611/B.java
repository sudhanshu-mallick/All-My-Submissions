import java.util.*;
import java.io.*;

public class New_Year_And_Old_Property {

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
		long a = t.nextLong();
		long b = t.nextLong();
		long count = 0;

		for (int i = 2; i <= 61; ++i) {
			char ch[] = new char[i];

			Arrays.fill(ch, '1');

			for (int j = 1; j < i; ++j) {
				ch[j] = '0';
				String num = new String(ch);
				long val = Long.parseLong(num, 2);
				ch[j] = '1';

				if (val >= a && val <= b)
					++count;
			}
		}

		o.println(count);
		o.flush();
		o.close();
	}
}