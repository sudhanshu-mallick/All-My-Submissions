import java.util.*;
import java.io.*;

public class Reorder_The_Array {

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
		int n = t.nextInt(), count = 0, s = 0, e = 0;
		Integer[] a = new Integer[n];

		for (int i = 0; i < n; a[i++] = t.nextInt()) {
		}

		Arrays.sort(a);

		while (e < n) {
			if (a[s].equals(a[e])) {
				e++;
			} else {
				count++;
				s++;
				e++;
			}
		}

		o.println(count);

		o.flush();
		o.close();
	}
}