import java.util.*;
import java.io.*;

public class Good_String {

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
		int n = t.nextInt(), i = 1, c = 0;
		char ch[] = t.next().toCharArray();
		ArrayList<Character> l = new ArrayList<>();
		l.add(ch[0]);

		while (i < n) {
			char ch1 = l.get(c);
			char ch2 = ch[i];

			if ((c & 1) == 1) {
				l.add(ch2);
				i++;
				c++;
			} else if (ch1 != ch2) {
				l.add(ch2);
				i++;
				c++;
			} else {
				while (i < n && ch1 == ch[i])
					++i;
			}
		}

		if ((l.size() & 1) == 1) {
			o.println(n + 1 - l.size());

			for (i = 0; i < l.size() - 1; ++i)
				o.print(l.get(i));

			o.println();
		} else {
			o.println(n - l.size());

			for (i = 0; i < l.size(); ++i)
				o.print(l.get(i));

			o.println();
		}

		o.flush();
		o.close();
	}
}