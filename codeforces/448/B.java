import java.util.*;
import java.io.*;

public class Suffix_Structures {

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
		String s1 = t.next();
		String s2 = t.next();
		HashMap<Character, Integer> map = new HashMap<>();
		int idx = 0, len = 0;
		boolean flag = true;

		for (int i = 0; i < s2.length(); ++i) {
			char ch = s2.charAt(i);

			while (idx < s1.length()) {
				if (ch == s1.charAt(idx)) {
					idx++;
					len++;
					break;
				}

				idx++;
			}
		}

		if (len == s2.length()) {
			o.println("automaton");
			o.close();
			return;
		}

		char temp[] = s1.toCharArray();

		Arrays.sort(temp);

		s1 = new String(temp);
		char tempo[] = s2.toCharArray();

		Arrays.sort(tempo);

		s2 = new String(tempo);

		if (s1.equals(s2)) {
			o.println("array");
			o.close();
			return;
		}

		for (int i = 0; i < s1.length(); ++i) {
			char ch = s1.charAt(i);

			if (map.containsKey(ch))
				map.put(ch, map.get(ch) + 1);
			else
				map.put(ch, 1);
		}

		for (int i = 0; i < s2.length(); ++i) {
			char ch = s2.charAt(i);

			if (map.containsKey(ch)) {
				if (map.get(ch) == 1)
					map.remove(ch);
				else
					map.put(ch, map.get(ch) - 1);
			} else {
				flag = false;
				break;
			}
		}

		if (flag) {
			o.println("both");
			o.close();
			return;
		}

		o.println("need tree");
		o.close();
		return;

	}
}