
import java.util.*;
import java.io.*;

public class Flamigoes_Of_Mystery {

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
		int[] a = new int[n];

		System.out.println("? 1 " + n);

		int v = t.nextInt();

		for (int i = n - 1; i > 1; --i) {
			System.out.println("? 1 " + i);

			int cur = t.nextInt();
			a[i] = v - cur;
			v = cur;
		}

		System.out.println("? 2 3");

		int cur = t.nextInt();
		a[1] = cur - a[2];
		a[0] = v - a[1];

		o.print("! ");

		for (int i = 0; i < n; ++i) {
			o.print(a[i] + " ");
		}

		o.flush();
		o.close();
	}
}