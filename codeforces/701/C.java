import java.util.*;
import java.io.*;

public class They_Are_Everywhere {

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
		String s = t.next();
		HashSet<Character> set = new HashSet<>();
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); ++i)
			set.add(s.charAt(i));

		int i = 0, j = 0, max = set.size(), cur = s.length();

		set.clear();

//		if (max == 1)
//			cur = 1;
//		else
		while (i <= j && j < s.length()) {
			char ch = s.charAt(j);

			if (map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);

			if (map.size() == max) {

				while (map.size() == max) {
					if (map.get(s.charAt(i)) > 1) {
						map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
						i++;
					} else
						map.remove(s.charAt(i));
				}

				cur = Math.min(cur, j - i + 1);
				// System.out.println(cur);
				i++;
				j++;
			} else {
				j++;
			}
		}

		o.println(cur);

		o.flush();
		o.close();
	}
}