import java.util.*;
import java.io.*;

public class Johhny_And_Ancient_Computer {

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
			long a = t.nextLong();
			long b = t.nextLong();
			long res = Math.max(a, b) / Math.min(a, b);
			String s = Long.toBinaryString(res);
			int count = 0, idx = 0;

			if (Math.max(a, b) % Math.min(a, b) != 0)
				count = 2;

			for (int i = 0; i < s.length(); ++i) {
				if (s.charAt(i) == '1') {
					count++;
					idx = i + 1;
				}

				if (count > 1)
					break;
			}

			idx = s.length() - 1;

			if (count > 1)
				o.println("-1");
			else {

//				System.out.println(idx);
				int three = idx / 3;
				int two = (idx - three * 3) / 2;
				int one = idx - three * 3 - two * 2;

//				System.out.println(idx);

				o.println(one + two + three);

			}

		}

		o.flush();
		o.close();
	}
}