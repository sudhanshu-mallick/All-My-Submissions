import java.util.*;
import java.io.*;

public class SUm_Of_Round {
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
			String s = t.next();
			int n = s.length();
			int i = 0;
			ArrayList<String> l = new ArrayList<>();

			while (i < n) {
				int rem = (int) (s.charAt(i) - '0');

				if (rem != 0) {
					StringBuilder sb = new StringBuilder();

					sb.append(rem);

					for (int j = i + 1; j < n; ++j)
						sb.append('0');

					l.add(sb.toString());
				}

				i++;
			}
			o.println(l.size());

			for (int j = 0; j < l.size(); ++j)
				o.print(l.get(j) + " ");

			o.println();

		}

		o.flush();
		o.close();
	}
}