import java.util.*;
import java.io.*;

public class Substring_Removal_Game {

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
			char ch[] = t.next().toCharArray();
			List<Integer> list = new ArrayList<>();
			int cur = 0;
			int sum = 0;

			for (int i = 0; i < ch.length; ++i) {
				if (ch[i] == '1') {
					cur++;
				} else {
					list.add(cur);

					cur = 0;
				}
			}

			list.add(cur);

			Collections.sort(list, Collections.reverseOrder());

			for (int i = 0; i < list.size(); i += 2) {
				sum += list.get(i);
			}

			o.println(sum);
		}

		o.flush();
		o.close();
	}
}