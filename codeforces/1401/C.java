import java.util.*;
import java.io.*;

public class Mere_Array {

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
			int[] a = new int[n];
			int[] b = new int[n];
			boolean flag = true;

			for (int i = 0; i < n; ++i)
				a[i] = b[i] = t.nextInt();

			Arrays.sort(a);

			for (int i = 0; i < n; ++i) {
				if (a[i] != b[i]) {
					if (a[i] % a[0] != 0) {
						flag = false;

						break;
					}
				}
			}

			if (flag)
				o.println("YES");
			else
				o.println("NO");
		}

		o.flush();
		o.close();
	}
}