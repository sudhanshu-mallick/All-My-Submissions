import java.util.*;
import java.io.*;

public class Wow_Factor {
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
		String s = t.next();
		int n = s.length();
		List<Integer> l = new ArrayList<>();
		int i = 0, cv = 0, cz = 0, flag = 0;

		while (i < n) {
			char ch = s.charAt(i);

			if (ch == 'v') {
				cv++;

				if (cv == 2) {
					l.add(cz);
					cz = 0;
				}
			} else {
				cz++;

				if (cz == 1) {
					l.add(cv);
					cv = 0;
				}

				cv = 0;
			}

			i++;
		}

		if (cv >= 2)
			l.add(cv);

		if (n == 1)
			o.println("0");
		else {
			if (s.charAt(0) == 'v' && s.charAt(1) == 'v') {
				long count = 0, ri = 0, le = 0;
				i = 1;

				while (i < l.size()) {
					ri += l.get(i) - 1;
					i += 2;
				}

				i = 2;
				le = l.get(1) - 1;
				ri = ri - l.get(1) + 1;

				while (i < l.size()) {
					count += le * ri * l.get(i);

					if (i + 1 < l.size()) {
						le += l.get(i + 1) - 1;
						ri = ri - l.get(i + 1) + 1;
					}

					i += 2;
				}

				o.println(count);

			} else {
				long count = 0, ri = 0, le = 0;
				i = 2;

				while (i < l.size()) {
					ri = ri + l.get(i) - 1;
					i += 2;
				}

				i = 3;

				if (l.size() > 2) {
					le = l.get(2) - 1;
					ri = ri - l.get(2) + 1;
				}

				while (i < l.size()) {
					count += le * ri * l.get(i);

					if (i + 1 < l.size()) {
						le += l.get(i + 1) - 1;
						ri = ri - l.get(i + 1) + 1;
					}

					i += 2;
				}

				o.println(count);
			}
		}

		o.flush();
		o.close();
	}

}