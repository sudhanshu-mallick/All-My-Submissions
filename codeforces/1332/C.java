import java.util.*;
import java.io.*;

public class K_Complete_Word {

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
			int n = t.nextInt(), k = t.nextInt(), x = 0, y = 0;
			char[][] a = new char[n / k][k];
			String s = t.next();
			int count = 0;

			for (int i = 0; i < n; i++) {
				if (x == k) {
					x = 0;
					y++;
					a[y][x++] = s.charAt(i);
				} else {
					a[y][x++] = s.charAt(i);
				}
			}

			x = k;
			y = n / k;

			for (int i = 0; i < k / 2; i++) {
				HashMap<Character, Integer> map = new HashMap<>();
				int max = 0;
				char cmax = ' ';

				for (int j = 0; j < y; j++) {
					char ch = a[j][i];

					if (map.containsKey(ch))
						map.put(ch, map.get(ch) + 1);
					else
						map.put(ch, 1);
				}

				for (int j = 0; j < y; j++) {
					char ch = a[j][k - i - 1];

					if (map.containsKey(ch))
						map.put(ch, map.get(ch) + 1);
					else
						map.put(ch, 1);
				}

				for (Character c : map.keySet()) {
					int val = map.get(c);

					if (val > max) {
						max = val;
						cmax = c;
					}
				}

				count += y * 2 - max;

			}

			if (k % 2 == 1) {
				HashMap<Character, Integer> map = new HashMap<>();
				int max = 0;
				char cmax = ' ';

				for (int j = 0; j < y; j++) {
					char ch = a[j][k / 2];

					if (map.containsKey(ch))
						map.put(ch, map.get(ch) + 1);
					else
						map.put(ch, 1);
				}

				for (Character c : map.keySet()) {
					int val = map.get(c);

					if (val > max) {
						max = val;
						cmax = c;
					}
				}

				count += y - max;
			}

			o.println(count);
		}
		o.flush();
		o.close();
	}
}