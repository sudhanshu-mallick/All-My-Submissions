import java.util.*;
import java.io.*;

public class Minimum_Ternary_String {

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
		char ch[] = t.next().toCharArray();
		int n = ch.length;
		int one = 0;
		List<Integer> two = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; ++i) {
			if (ch[i] == '1')
				++one;
			else if (ch[i] == '2')
				two.add(i);
		}

		two.add(n);

		int i = 0;
		int zero = 0;

		while (i < two.get(0)) {
			if (ch[i] == '0')
				++zero;

			++i;
		}

		while (zero-- > 0)
			sb.append("0");

		while (one-- > 0)
			sb.append("1");

		int cur = 1;
		zero = 0;

		if (i < n)
			sb.append("2");

		while (i < n) {
			if (i < two.get(cur)) {
				if (ch[i] == '0')
					++zero;
			} else {
				++cur;

				while (zero-- > 0) {
					sb.append("0");
				}

				sb.append("2");
				
				zero = 0;
			}

			++i;
		}

		while (zero-- > 0)
			sb.append("0");

		o.println(sb);
		o.flush();
		o.close();
	}
}