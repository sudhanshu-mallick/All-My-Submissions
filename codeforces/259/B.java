import java.util.*;
import java.io.*;

public class Little_Elephant_And_Magic_Square {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int[][] mat = new int[3][3];

		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				mat[i][j] = t.nextInt();

		int req = (mat[1][0] + mat[2][1] + mat[0][2] + mat[2][0] * 3) >> 1;
		mat[0][0] = req - mat[1][0] - mat[2][0];
		mat[1][1] = req - mat[2][0] - mat[0][2];
		mat[2][2] = req - mat[2][0] - mat[2][1];

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j)
				o.print(mat[i][j] + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}
