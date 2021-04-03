import java.util.*;
import java.io.*;

public class Deja_Vu {

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
			String s = t.next();
			boolean flag = false;

			if (!checkPalindrome("a" + s)) {
				flag = true;
				s = "a" + s;
			} else if (!checkPalindrome(s + "a")) {
				flag = true;
				s = s + "a";
			}

			if (flag)
				o.println("YES\n" + s);
			else
				o.println("NO");

		}

		o.flush();
		o.close();
	}

	private static boolean checkPalindrome(String s) {
		int i = 0, j = s.length() - 1;

		while (i < j)
			if (s.charAt(i) != s.charAt(j))
				return false;
			else {
				++i;
				--j;
			}

		return true;
	}
}