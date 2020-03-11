import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Letter {

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
		String s1 = "", s2 = "";
		s1 = t.nextLine();
		s2 = t.nextLine();
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == ' ') {

			} else {
				char c = s1.charAt(i);

				if (map.containsKey(c)) {
					int val = map.get(c);
					map.put(c, val + 1);
				} else {
					map.put(c, 1);
				}
			}
		}

		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) != ' ') {
				char c = s2.charAt(i);

				if (map.containsKey(c)) {
					if (map.get(c) == 1)
						map.remove(c);
					else {
						int val = map.get(c);
						map.put(c, val - 1);
					}

				} else {
					o.println("NO");
					o.close();
					return;
				}
			}
		}

		o.println("YES");
		o.close();
	}

}
