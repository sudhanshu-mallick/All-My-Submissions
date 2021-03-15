import java.util.*;
import java.io.*;

public class Greg_And_Array {

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
		int n = t.nextInt();
		int m = t.nextInt();
		int k = t.nextInt();
		long[] a = new long[n];
		long[][] opr = new long[m][3];
		long[][] query = new long[k][2];
		long[] queryFinal = new long[m];
		long[] res = new long[n];

		for (int i = 0; i < n; ++i)
			a[i] = t.nextLong();

		for (int i = 0; i < m; ++i) {
			opr[i][0] = t.nextLong();
			opr[i][1] = t.nextLong();
			opr[i][2] = t.nextLong();
		}

		for (int i = 0; i < k; ++i) {
			long x = t.nextLong() - 1;
			long y = t.nextLong();
			++queryFinal[(int) x];

			if (y < m)
				--queryFinal[(int) y];
		}

		for (int i = 1; i < m; ++i)
			queryFinal[i] += queryFinal[i - 1];

		for (int i = 0; i < m; ++i) {
			long x = opr[i][0] - 1;
			long y = opr[i][1];
			res[(int) x] += queryFinal[i] * opr[i][2];

			if (y < n)
				res[(int) y] -= queryFinal[i] * opr[i][2];
		}

		for (int i = 1; i < n; ++i)
			res[i] += res[i - 1];

		for (int i = 0; i < n; ++i)
			res[i] += a[i];

		for (long v : res)
			o.print(v + " ");

		o.flush();
		o.close();
	}
}