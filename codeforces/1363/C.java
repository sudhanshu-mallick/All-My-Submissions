import java.util.*;
import java.io.*;

public class Game_On_Leaves {

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
			int x = t.nextInt();

			for (int i = 0; i < n - 1; ++i) {
				int u = t.nextInt();
				int v = t.nextInt();
				a[u - 1]++;
				a[v - 1]++;
			}

			if (a[x - 1] <= 1)
				o.println("Ayush");
			else {
				if ((n & 1) == 1)
					o.println("Ashish");
				else
					o.println("Ayush");
			}

		}

		o.flush();
		o.close();
	}
}