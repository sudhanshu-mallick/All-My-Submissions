import java.io.*;
import java.util.*;

public class Cow_And_Friend {

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
			int n = t.nextInt(), len = t.nextInt(), max = 0;
			long count = 0;
			HashSet<Integer> map = new HashSet<>();

			for (int i = 0; i < n; ++i) {
				int ele = t.nextInt();
				max = Math.max(max, ele);

				map.add(ele);
			}

			if (len / max == 0) {
				if (map.contains(len))
					count = 1;
				else
					count = 2;
			} else {
				count = len / max;

				if (len % max != 0)
					count++;

			}

			o.println(count);

		}

		o.flush();
		o.close();
	}
}