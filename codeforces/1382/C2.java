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
		StringBuilder sb = new StringBuilder();

		while (test-- > 0) {
			int n = t.nextInt();
			char a[] = t.next().toCharArray();
			char b[] = t.next().toCharArray();
			List<Integer> list = new ArrayList<>();
			int x = 0, y = n - 1;
			boolean flag = false;

			for (int i = n - 1; i >= 0; --i) {
				if (!flag) {
					if (a[x] == b[i]) {
						list.add(1);
					}

					++x;

					list.add(i + 1);
				} else {
					if (a[y] != b[i]) {
						list.add(1);
					}

					--y;

					list.add(i + 1);
				}

				flag = !flag;
			}

			sb.append(list.size() + " ");

			for (int val : list) {
				sb.append(val + " ");
			}

			sb.append("\n");
		}

		o.println(sb);
		o.flush();
		o.close();
	}
}