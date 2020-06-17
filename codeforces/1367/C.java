import java.util.*;
import java.io.*;

public class Social_Distance {

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
			int n = t.nextInt();
			int k = t.nextInt();
			String s = t.next();
			int count = 0;
			List<Integer> l = new ArrayList<>();

			for (int i = 0; i < n; ++i)
				if (s.charAt(i) == '1')
					l.add(i);

			if (l.size() == 0) {
				count = (n + k) / (k + 1);
			} else {
				if (l.size() > 1) {
					for (int i = 0; i < l.size() - 1; ++i) {
						int x = l.get(i) + k + 1;
						int y = l.get(i + 1) - k - 1;
						int len = y - x + 1;

						if (len > 0)
							count += (len + k) / (k + 1);
					}

					int len = n - (l.get(l.size() - 1) + k + 1);

					if (len > 0)
						count += (len + k) / (k + 1);

					len = l.get(0) - k;

					if (len > 0)
						count += (len + k) / (k + 1);

				} else {
					int len = l.get(0) - k;

					if (len > 0)
						count += (len + k) / (k + 1);

					len = n - (l.get(l.size() - 1) + k + 1);

					if (len > 0)
						count += (len + k) / (k + 1);
				}

			}

			o.println(count);
		}

		o.flush();
		o.close();
	}
}