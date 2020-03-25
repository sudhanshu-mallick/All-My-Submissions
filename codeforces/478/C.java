import java.io.*;
import java.util.*;

public class Table_Decoration {

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
		long[] a = new long[3];

		for (int i = 0; i < 3; i++)
			a[i] = t.nextLong();

		Arrays.sort(a);

		if (2 * (a[0] + a[1]) <= a[2])
			o.println(a[0] + a[1]);
		else
			o.println((a[0] + a[1] + a[2]) / 3);

		o.flush();
		o.close();
	}
}