import java.util.*;
import java.io.*;

public class Less_Or_Equal {

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
		int n = t.nextInt(), k = t.nextInt(), flag = 0, j = 0;
		Integer[] a = new Integer[n + 1];
		a[0] = 1;

		for (int i = 1; i <= n; i++)
			a[i] = t.nextInt();

		Arrays.sort(a);

		if (k == n) {
			o.println(a[n]);
		} else if (a[k] < a[k + 1])
			o.println(a[k]);
		else
			o.println(-1);

		o.flush();
		o.close();
	}
}