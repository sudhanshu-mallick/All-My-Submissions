import java.util.*;
import java.io.*;

public class Balance_The_Bits {

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
			char[] ch = t.next().toCharArray();
			char[] a = new char[n];
			char[] b = new char[n];
			int start = 0;
			boolean flag = true;
			int zero = 0, one = 0;

			for (int i = 0; i < n; ++i)
				if (ch[i] == '0')
					++zero;

			if ((zero & 1) == 0) {
				for (int i = 0; i < n; ++i)
					if (ch[i] == '0') {
						if (start == 0) {
							a[i] = '(';
							b[i] = ')';
						} else {
							a[i] = ')';
							b[i] = '(';
						}

						start ^= 1;
					}

				int cnt = (n - zero) >> 1;
				int i = 0;

				while (cnt > 0) {
					if (ch[i] == '1') {
						a[i] = b[i] = '(';
						--cnt;
					}

					++i;
				}

				while (i < n) {
					if (ch[i] == '1')
						a[i] = b[i] = ')';
					
					++i;
				}

				int cur = 0;

				for (char c : a) {
					if (c == ')')
						--cur;
					else
						++cur;

					if (cur < 0) {
						flag = false;
						break;
					}
				}

				if (cur != 0)
					flag = false;

				if (flag)
					for (char c : b) {
						if (c == ')')
							--cur;
						else
							++cur;

						if (cur < 0) {
							flag = false;
						}
					}

				if (cur != 0)
					flag = false;

				if (flag) {
					o.println("YES");
					o.println(new String(a));
					o.println(new String(b));
				} else
					o.println("NO");
			} else {
				o.println("NO");
			}
		}

		o.flush();
		o.close();
	}
}