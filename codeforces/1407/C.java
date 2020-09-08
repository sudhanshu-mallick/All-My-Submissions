import java.util.*;
import java.io.*;

public class Chocolate_Bunny {

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
		StringBuilder sb = new StringBuilder();
		int n = t.nextInt();
		int[] a = new int[n];

		if (n == 1) {
			System.out.println("! 1");
			return;
		}

		int x = 1, y = 2;

		while (y <= n) {
			System.out.println("? " + x + " " + y);
			int k1 = t.nextInt();
			System.out.println("? " + y + " " + x);
			int k2 = t.nextInt();

			if (k1 < k2) {
				a[y - 1] = k2;
				y++;
			} else {
				a[x - 1] = k1;
				x = y;
				y++;
			}
		}

		a[x - 1] = n;

		sb.append("! ");

		for (int i = 0; i < n; ++i)
			sb.append(a[i] + " ");

		o.println(sb);

		o.close();
	}
}