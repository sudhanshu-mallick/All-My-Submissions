import java.util.*;
import java.io.*;

public class Going_Home {

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
		int n = t.nextInt();
		int[] a = new int[n];
		int[] x = new int[5000001];
		int[] y = new int[5000001];
		boolean flag = false;

		Arrays.fill(x, -1);
		Arrays.fill(y, -1);

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				int sum = a[i] + a[j];

				if (x[sum] == -1) {
					x[sum] = i;
					y[sum] = j;
				} else {
					if (!(x[sum] == i || x[sum] == j || y[sum] == i || y[sum] == j)) {
						flag = true;

						o.println("YES");
						o.println((x[sum] + 1) + " " + (y[sum] + 1) + " " + (i + 1) + " " + (j + 1));
						break;
					}
				}
			}
			if (flag)
				break;
		}
		if (!flag)
			o.println("NO");

		o.flush();
		o.close();
	}
}