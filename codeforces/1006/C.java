import java.io.*;
import java.util.*;

public class Three_Parts_Of_Array {

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
		int n = t.nextInt();
		long[] a = new long[n];
		long ls = 0, rs = 0, cs = 0;

		for (int i = 0; i < n; i++)
			a[i] = t.nextLong();

		int i = 0, j = n - 1;

		while (i < j) {
			if (ls == rs) {
				cs = Math.max(cs, ls);
				ls += a[i];
				rs += a[j];
				i++;
				j--;
			}

			else if (ls > rs) {
				rs += a[j];
				j--;
			} else {
				ls += a[i];
				i++;
			}
		}

		if (ls == rs)
			cs = Math.max(cs, ls);
		else if (ls > rs) {
			if (ls == rs + a[j])
				cs = ls;
		} else {
			if (rs == ls + a[j])
				cs = rs;
		}

		o.println(cs);

		o.flush();
		o.close();
	}
}