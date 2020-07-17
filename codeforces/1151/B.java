import java.util.*;
import java.io.*;

public class Dima_And_Bad_XOR {

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
		int m = t.nextInt();
		int n = t.nextInt();
		int[][] a = new int[m][n];
		List<Integer> same = new ArrayList<>();
		List<Integer> diff = new ArrayList<>();

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				a[i][j] = t.nextInt();
			}

			boolean f = true;
			int v = a[i][0];

			for (int j = 1; j < n; ++j) {
				if (a[i][j] != v) {
					f = false;
					break;
				}
			}

			if (f)
				same.add(i);
			else
				diff.add(i);
		}

		int ans = 0;
		int[] res = new int[m];

		for (int i = 0; i < same.size(); ++i) {
			ans = ans ^ a[same.get(i)][0];
			res[same.get(i)] = 1;
		}

		for (int i = 0; i < diff.size(); ++i) {
			int idx = diff.get(i);

			for (int j = 0; j < n; ++j) {
				int v = ans ^ a[idx][j];

				if (v != 0) {
					ans = v;
					res[idx] = j + 1;
					break;
				}
			}
		}

		if (ans == 0)
			o.println("NIE");
		else {
			o.println("TAK");

			for (int idx : res)
				o.print(idx + " ");
		}

		o.flush();
		o.close();
	}
}