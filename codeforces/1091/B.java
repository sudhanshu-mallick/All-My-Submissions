import java.util.*;
import java.io.*;

public class Treasure_Geolocation {

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
		p1 a1[] = new p1[n];
		p1 a2[] = new p1[n];
		Compare1 o1 = new Compare1();
		Compare2 o2 = new Compare2();

		for (int i = 0; i < n; ++i) {
			int x = t.nextInt(), y = t.nextInt();
			a1[i] = new p1(x, y);
		}

		for (int i = 0; i < n; ++i) {
			int x = t.nextInt(), y = t.nextInt();
			a2[i] = new p1(x, y);
		}

		o1.compare(a1, n);
		o2.compare(a2, n);

		int x = a1[0].x + a2[0].x;
		int y = a1[0].y + a2[0].y;

		o.print(x + " " + y);

		o.flush();
		o.close();
	}
}

class p1 {
	int x, y;

	public p1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Compare1 {

	static void compare(p1 arr[], int n) {
		Arrays.sort(arr, new Comparator<p1>() {
			@Override
			public int compare(p1 a, p1 b) {
				if (a.x != b.x)
					return a.x - b.x;
				else
					return a.y - b.y;
			}
		});
	}
}

class Compare2 {

	static void compare(p1 arr[], int n) {
		Arrays.sort(arr, new Comparator<p1>() {
			@Override
			public int compare(p1 a, p1 b) {
				if (a.x != b.x)
					return b.x - a.x;
				else
					return b.y - a.y;
			}
		});
	}
}
