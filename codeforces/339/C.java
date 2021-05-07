import java.util.*;
import java.io.*;

public class Xenia_And_Weights {

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
		char[] ch = t.next().toCharArray();
		int m = t.nextInt();
		int[] ar = new int[m];

		solve(ch, 0, m, 0, ar);

		if (!flag)
			o.println("NO");

		o.flush();
		o.close();
	}

	private static boolean flag = false;
	static private PrintWriter o = new PrintWriter(System.out);

	private static void solve(char[] ch, int bal, int m, int prev, int[] ar) {
		if (flag)
			return;

		if (m == 0) {
			flag = true;
			o.println("YES");

			for (int i = ar.length - 1; i >= 0; --i)
				o.print(ar[i] + " ");
		} else {
			for (int i = bal + 1; i <= 10; ++i) {
				if (ch[i - 1] == '1' && i != prev) {
					ar[m - 1] = i;

					solve(ch, i - bal, m - 1, i, ar);
				}
			}
		}
	}
}