import java.util.*;
import java.io.*;

public class Rank_List {

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
		int rank = t.nextInt();
		Pair[] a = new Pair[n];

		for (int i = 0; i < n; ++i) {
			int x = t.nextInt();
			int y = t.nextInt();
			a[i] = new Pair(x, y);
		}

		ompare ob = new ompare();
		ob.compare(a, n);

		int x = a[rank - 1].x;
		int y = a[rank - 1].y;
		int count = 0;

		for (int i = 0; i < n; ++i) {
			if (a[i].x == x && a[i].y == y)
				count++;
		}

		o.println(count);

		o.flush();
		o.close();
	}

}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class ompare {

	void compare(Pair arr[], int n) {
		Arrays.sort(arr, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if (p2.x != p1.x)
					return p2.x - p1.x;
				else
					return p1.y - p2.y;
			}
		});
	}
}
