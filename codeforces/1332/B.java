import java.io.*;
import java.util.*;

public class Composite_Coloring {

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
		int[] col = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			int[][] a = new int[2][n];
			HashMap<Integer, Integer> map = new HashMap<>();
			int cur = 1;

			for (int i = 0; i < n; i++) {
				a[0][i] = t.nextInt();

				for (int j = 0; j < 11; j++) {
					if (a[0][i] % col[j] == 0) {
						if (!map.containsKey(j)) {
							map.put(j, cur);
							cur++;
						}

						a[1][i] = j;
						break;
					}
				}
			}

			o.println(map.size());

			for (int i = 0; i < n; i++) {
				int val = map.get(a[1][i]);
				o.print(val + " ");
			}

			o.println();

		}
		o.flush();
		o.close();
	}
}