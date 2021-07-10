import java.util.*;
import java.io.*;

public class Shortest_Path_With_Obstacle {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int x1 = t.nextInt();
			int y1 = t.nextInt();
			int x2 = t.nextInt();
			int y2 = t.nextInt();
			int x3 = t.nextInt();
			int y3 = t.nextInt();

			if (x1 == x2 || y1 == y2) {
				if (x1 == x2) {
					if (x1 == x3 && y3 <= Math.max(y1, y2) && y3 >= Math.min(y1, y2)) {
						o.println(Math.abs(y1 - y2) + 2);
					} else
						o.println(Math.abs(y1 - y2));
				} else {
					if (y1 == y3 && x3 <= Math.max(x1, x2) && x3 >= Math.min(x1, x2)) {
						o.println(Math.abs(x1 - x2) + 2);
					} else
						o.println(Math.abs(x1 - x2));
				}
			} else
				o.println(Math.abs(x1 - x2) + Math.abs(y1 - y2));
		}

		o.flush();
		o.close();
	}
}