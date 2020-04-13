import java.util.*;
import java.io.*;

public class Array_Sharpening {

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
		int[] a = new int[300001];

		while (test-- > 0) {
			int n = t.nextInt();
			int k1 = -1, k2 = n;

			for (int i = 0; i < n; ++i)
				a[i] = t.nextInt();

			for (int i = 0; i < n; ++i) {
				if (a[i] >= i)
					k1 = i;
				else
					break;
			}

			for (int i = 0; i < n; ++i) {
				if (a[n - i - 1] >= i)
					k2 = n - i - 1;
				else
					break;
			}

			if (k1 >= k2)
				o.println("Yes");
			else
				o.println("No");

		}

		o.flush();
		o.close();
	}
}