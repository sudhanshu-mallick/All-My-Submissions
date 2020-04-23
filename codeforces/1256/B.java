import java.util.*;
import java.io.*;

public class Minimize_The_Permutation {

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
			int a[] = new int[n + 1];

			for (int i = 1; i <= n; ++i)
				a[i] = t.nextInt();

			int i = 1;

			while (i <= n) {
				int mi = i;

				for (int j = i + 1; j <= n; ++j)
					if (a[j] < a[mi])
						mi = j;

				int temp = a[mi];

				for (int j = mi; j > i; --j)
					a[j] = a[j - 1];

				a[i] = temp;

				if (i == mi)
					i++;
				else
					i = mi;
			}

			for (int j = 1; j <= n; ++j)
				o.print(a[j] + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}