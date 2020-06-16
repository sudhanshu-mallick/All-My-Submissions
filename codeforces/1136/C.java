import java.util.*;
import java.io.*;

public class Nastya_Is_Transporting_Matrix {

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
		int[][] b = new int[m][n];
		ArrayList<Integer>[] l1 = new ArrayList[m + n - 1];
		ArrayList<Integer>[] l2 = new ArrayList[m + n - 1];
		boolean flag = true;

		for (int i = 0; i < m + n - 1; ++i) {
			l1[i] = new ArrayList<>();
			l2[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				a[i][j] = t.nextInt();
				l1[i + j].add(a[i][j]);
			}
		}

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				b[i][j] = t.nextInt();
				l2[i + j].add(b[i][j]);
			}
		}

		for (int i = 0; i < m + n - 1; ++i) {
			Collections.sort(l1[i]);
			Collections.sort(l2[i]);

			for (int j = 0; j < l1[i].size(); ++j)
				if (l1[i].get(j).intValue() != l2[i].get(j).intValue()) {
					flag = false;
					break;
				}
		}

		if (flag)
			o.println("YES");
		else
			o.println("NO");

		o.flush();
		o.close();
	}
}
