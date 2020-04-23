import java.util.*;
import java.io.*;

public class Vitaliy_And_Pie {

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
		int n = t.nextInt(), count = 0;
		String s = t.next();
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < 2 * n - 2; i += 2) {
			char ch = (char) (s.charAt(i) - 32);
			char c = s.charAt(i + 1);

			if (ch == c)
				continue;

			if (map.containsKey(c)) {
				int val = map.get(c);

				if (val == 1)
					map.remove(c);
				else
					map.put(c, val - 1);

				if (map.containsKey(ch))
					map.put(ch, map.get(ch) + 1);
				else
					map.put(ch, 1);
			} else {
				count++;

				if (map.containsKey(ch))
					map.put(ch, map.get(ch) + 1);
				else
					map.put(ch, 1);
			}
		}

		o.println(count);

		o.flush();
		o.close();
	}
}