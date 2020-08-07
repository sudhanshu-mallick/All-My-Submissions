
import java.util.*;
import java.io.*;

public class Applejack_And_Storages {

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
		int n = t.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		int four = 0, six = 0, two = 0, eight = 0;

		for (int i = 0; i < n; ++i) {
			int x = t.nextInt();
			int val = map.getOrDefault(x, 0) + 1;

			if (val == 2)
				two++;
			else if (val == 4) {
				four++;
				two--;
			} else if (val == 6) {
				six++;
				four--;
			} else if (val == 8) {
				eight++;
				six--;
			}

			map.put(x, val);
		}

		int q = t.nextInt();

		while (q-- > 0) {
			char ch = t.next().charAt(0);
			int x = t.nextInt();

			if (ch == '+') {
				int val = map.getOrDefault(x, 0) + 1;

				if (val == 2)
					two++;
				else if (val == 4) {
					four++;
					two--;
				} else if (val == 6) {
					six++;
					four--;
				} else if (val == 8) {
					eight++;
					six--;
				}

				map.put(x, val);
			} else {
				int val = map.get(x);

				if (val == 2) {
					two--;
				} else if (val == 4) {
					four--;
					two++;
				} else if (val == 6) {
					six--;
					four++;
				} else if (val == 8) {
					eight--;
					six++;
				}

				if (val == 1)
					map.remove(x);
				else
					map.put(x, val - 1);
			}

			if (eight > 0) {
				o.println("YES");
			} else if (six > 0 && (four >= 1 || two >= 1 || six > 1)) {
				o.println("YES");
			} else if (four > 0 && (four > 1 || two > 1)) {
				o.println("YES");
			} else
				o.println("NO");
		}

		o.flush();
		o.close();
	}

}