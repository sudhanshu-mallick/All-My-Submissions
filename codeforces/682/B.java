import java.util.*;
import java.io.*;

public class Alonya_And_Mex {

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
		int n = t.nextInt(), cur = 1;
		Integer[] a = new Integer[n];

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		Arrays.sort(a);

		for (int i = 0; i < n; ++i) {
			if (cur <= a[i])
				cur++;
		}

		o.println(cur);

		o.flush();
		o.close();
	}
}