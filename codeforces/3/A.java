import java.util.*;
import java.io.*;

public class Shortest_Path_Of_The_King {

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
		int y1 = s1.charAt(0) - 'a' + 1;
		int x1 = '8' - s1.charAt(1) + 1;
		String s2 = t.next();
		int y2 = s2.charAt(0) - 'a' + 1;
		int x2 = '8' - s2.charAt(1) + 1;
		List<String> ans = new ArrayList<>();

		while (x1 != x2 && y1 != y2) {
			if (x1 > x2 && y1 > y2) {
				x1--;
				y1--;

				ans.add("LU");
			} else if (x1 < x2 && y1 < y2) {
				x1++;
				y1++;

				ans.add("RD");
			} else if (x1 < x2 && y1 > y2) {
				x1++;
				y1--;

				ans.add("LD");
			} else {
				x1--;
				y1++;

				ans.add("RU");
			}
		}

		while (x1 != x2) {
			if (x1 > x2) {
				x1--;

				ans.add("U");
			} else {
				x1++;

				ans.add("D");
			}
		}

		while (y1 != y2) {
			if (y1 > y2) {
				y1--;

				ans.add("L");
			} else {
				y1++;

				ans.add("R");
			}
		}

		o.println(ans.size());

		for (String s : ans)
			o.println(s);

		o.flush();
		o.close();
	}
}
