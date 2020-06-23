import java.util.*;
import java.io.*;

public class Minimize_The_Integer {

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
			String s = t.next();
			StringBuilder ans = new StringBuilder();
			List<Integer> odd = new ArrayList<>();
			List<Integer> even = new ArrayList<>();

			for (int i = 0; i < s.length(); ++i) {
				int v = s.charAt(i) - '0';

				if ((v & 1) == 1)
					odd.add(v);
				else
					even.add(v);
			}

			int i = 0, j = 0;

			while (i < odd.size() && j < even.size()) {
				if (odd.get(i) < even.get(j))
					ans.append(odd.get(i++));
				else
					ans.append(even.get(j++));
			}

			while (i < odd.size())
				ans.append(odd.get(i++));

			while (j < even.size())
				ans.append(even.get(j++));

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}