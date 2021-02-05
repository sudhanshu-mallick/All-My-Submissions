import java.util.*;
import java.io.*;

public class Space_Navigation {

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
			int x = t.nextInt();
			int y = t.nextInt();
			String s = t.next();
			int up = 0, down = 0, right = 0, left = 0;
			boolean f1 = false, f2 = false;

			for (char ch : s.toCharArray()) {
				if (ch == 'R')
					++right;
				else if (ch == 'L')
					++left;
				else if (ch == 'U')
					++up;
				else
					++down;
			}

			if (y > 0) {
				if (up >= y)
					f1 = true;
			} else {
				if (down >= -y)
					f1 = true;
			}

			if (x > 0) {
				if (right >= x)
					f2 = true;
			} else {
				if (left >= -x)
					f2 = true;
			}

			if (f1 && f2)
				o.println("YES");
			else
				o.println("NO");
		}

		o.flush();
		o.close();
	}
}