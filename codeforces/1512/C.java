import java.util.*;
import java.io.*;

public class A_B_Palindrome {

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
		a[i] = a[i] ^ a[j];
		a[j] = a[i] ^ a[j];
		a[i] = a[i] ^ a[j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			int a = t.nextInt();
			int b = t.nextInt();
			char[] ch = t.next().toCharArray();
			int n = ch.length;
			boolean flag = true;

			for (int i = 0, j = n - 1; i < j; ++i, --j) {
				if (ch[i] == '?' || ch[j] == '?') {
					if (ch[i] != '?')
						ch[j] = ch[i];
					else if (ch[j] != '?')
						ch[i] = ch[j];
				} else {
					if (ch[i] != ch[j]) {
						flag = false;
						break;
					}
				}
			}

			for (int i = 0; i < n; ++i)
				if (ch[i] == '1')
					--b;
				else if (ch[i] == '0')
					--a;

			if (a < 0 || b < 0)
				flag = false;

			int i = 0, j = n - 1;

			while (i < j) {
				if (ch[i] == '?') {
					if (a > 1) {
						ch[i] = ch[j] = '0';
						a -= 2;
					} else if (b > 1) {
						ch[i] = ch[j] = '1';
						b -= 2;
					} else {
						flag = false;
					}
				}

				++i;
				--j;
			}

			if (i == j && ch[i] == '?')
				if (a == 1)
					ch[i] = '0';
				else
					ch[j] = '1';

			o.println(flag ? new String(ch) : "-1");
		}

		o.flush();
		o.close();
	}
}