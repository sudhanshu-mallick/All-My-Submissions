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
			List<Integer> list = new ArrayList<>();
			int x = 0, y = n - 1;

			for (int i = n - 1; i >= 0; i--) {
				if ((i & 1) != (n & 1)) {
					if (a[x] == b[i]) {
						x++;

						list.add(1);
						list.add(i + 1);
					} else {
						x++;

						list.add(i + 1);
					}
				} else {
					if (a[y] == b[i]) {
						y--;

						list.add(i + 1);
					} else {
						y--;

						list.add(1);
						list.add(i + 1);
					}
				}
			}

			o.print(list.size() + " ");

			for (int val : list) {
				o.print(val + " ");
			}

			o.println();
		}

		o.flush();
		o.close();
	}
}