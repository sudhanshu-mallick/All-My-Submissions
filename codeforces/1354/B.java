import java.util.*;
import java.io.*;

public class Ternary_String {

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
			Set<Character> set = new HashSet<>();
			int[] a = new int[3];

			for (int i = 0; i < s.length(); ++i)
				set.add(s.charAt(i));

			if (set.size() != 3)
				o.println("0");
			else {
				int si = 0, sid = -1, ans = Integer.MAX_VALUE, count = 0;
				int as[] = new int[3];

				for (int i = 0; i < s.length(); ++i) {
					as[s.charAt(i) - '1']++;

					if (as[s.charAt(i) - '1'] == 1)
						count++;

					if (count == 3) {
						while (as[s.charAt(si) - '1'] > 1) {
							if (as[s.charAt(si) - '1'] > 1)
								as[s.charAt(si) - '1']--;

							si++;
						}

						if (ans > i - si + 1) {
							ans = i - si + 1;
							sid = si;
						}
					}
				}

				o.println(ans);
			}
		}

		o.flush();
		o.close();
	}
}