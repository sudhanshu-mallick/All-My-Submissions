import java.util.*;
import java.io.*;

public class Berland_Crossword {

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
			int n = t.nextInt();
			int[] a = new int[4];
			boolean res = true;

			for (int i = 0; i < 4; ++i)
				a[i] = t.nextInt();

			for (int i = 0; i < 4; ++i) {
				int prev = i == 0 ? (3) : (i - 1);
				int next = (i + 1) % 4;

				if (a[i] == 0) {
					if (a[prev] == n || a[next] == n)
						res = false;
					else if (a[(i + 2) % 4] == 0 && (a[prev] == n - 1 || a[next] == n - 1))
						res = false;
					else if (a[(i + 2) % 4] == 1 && a[prev] == a[next] && a[prev] == n - 1)
						res = false;
				} else if (a[i] == 1) {
					if (a[prev] == n && a[next] == n)
						res = false;
					else if ((a[prev] == n || a[next] == n) && (a[prev] == n - 1 || a[next] == n - 1)
							&& a[(i + 2) % 4] <= 1)
						res = false;
				}

			}

			o.println(res ? "YES" : "NO");
		}

		o.flush();
		o.close();
	}
}