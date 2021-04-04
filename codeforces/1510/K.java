import java.util.*;
import java.io.*;

public class Kings_Task {

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
		int[] a = new int[n << 1];
		int[] b = new int[n << 1];
		int cur = 2001;
		boolean flag = true;
		int count = 0;

		for (int i = 0; i < a.length; ++i)
			b[i] = a[i] = t.nextInt();

		for (int i = 0; i < a.length; ++i)
			if (a[i] != i + 1) {
				flag = false;
				break;
			}

		if (!flag)
			while (cur-- > 0) {
				flag = true;

				if ((cur & 1) == 0) {
					for (int i = 0; i < n; ++i) {
						int temp = a[i];
						a[i] = a[n + i];
						a[n + i] = temp;
					}

					for (int i = 0; i < a.length; i += 2) {
						int temp = b[i];
						b[i] = b[i + 1];
						b[i + 1] = temp;
					}
				} else {
					for (int i = 0; i < a.length; i += 2) {
						int temp = a[i];
						a[i] = a[i + 1];
						a[i + 1] = temp;
					}

					for (int i = 0; i < n; ++i) {
						int temp = b[i];
						b[i] = b[n + i];
						b[n + i] = temp;
					}
				}

				++count;

				for (int i = 0; i < a.length; ++i)
					if (a[i] != i + 1) {
						flag = false;
						break;
					}

				if (flag)
					break;

				flag = true;

				for (int i = 0; i < a.length; ++i)
					if (b[i] != i + 1) {
						flag = false;
						break;
					}

				if (flag)
					break;
			}

		if (flag) {
			o.println(count);
		} else
			o.println("-1");

		o.flush();
		o.close();
	}
}