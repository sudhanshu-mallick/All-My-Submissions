import java.util.*;
import java.io.*;

public class Planet_Lapituliti {

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
			int h = t.nextInt();
			int m = t.nextInt();
			String s = t.next();
			int[] a = { Integer.parseInt(s.substring(0, 1)), Integer.parseInt(s.substring(1, 2)),
					Integer.parseInt(s.substring(3, 4)), Integer.parseInt(s.substring(4)) };
			int curh = a[0] * 10 + a[1];
			int curm = a[2] * 10 + a[3];
			int ch = curh;
			int cm = curm;

			while (true) {
				if (!check(a, h, m)) {
					curm = (curm + 1) % m;

					if (curm == 0)
						curh = (curh + 1) % h;

					a[0] = curh / 10;
					a[1] = curh % 10;
					a[2] = curm / 10;
					a[3] = curm % 10;
				} else
					break;
			}

			o.println(a[0] + "" + a[1] + ":" + a[2] + "" + a[3]);

		}

		o.flush();
		o.close();
	}

	private static boolean check(int[] a, int h, int m) {
		int n = 3;
		int[] b = new int[4];

		for (int i = 0; i < 4; ++i) {
			if (a[i] == 0)
				b[n - i] = 0;

			if (a[i] == 1)
				b[n - i] = 1;

			if (a[i] == 2)
				b[n - i] = 5;

			if (a[i] == 3)
				return false;

			if (a[i] == 4)
				return false;

			if (a[i] == 5)
				b[n - i] = 2;

			if (a[i] == 6)
				return false;

			if (a[i] == 7)
				return false;

			if (a[i] == 8)
				b[n - i] = 8;

			if (a[i] == 9)
				return false;
		}

		if (b[0] * 10 + b[1] >= h || b[2] * 10 + b[3] >= m)
			return false;

		return true;
	}
}