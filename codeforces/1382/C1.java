import java.util.*;
import java.io.*;

public class Prefix_Flip {

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
			char a[] = t.next().toCharArray();
			char b[] = t.next().toCharArray();
			int cnt = 0;
			List<Integer> list = new ArrayList<>();

			for (int i = n - 1; i > 0; --i) {
				int v1 = a[i] - '0';
				int v2 = b[i] - '0';

				if (v1 != v2) {
					list.add(i + 1);
					list.add(1);
					list.add(i + 1);

					cnt = cnt ^ 1;
				}
			}

			if (a[0] != b[0])
				list.add(1);

			o.print(list.size() + " ");

			for (int val : list)
				o.print(val + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}
