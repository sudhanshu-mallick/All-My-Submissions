import java.util.*;
import java.io.*;

public class Ordinary_Numbers {

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
			StringBuilder sb[] = new StringBuilder[9];
			int count = 0;

			for (int i = 1; i < 10; ++i)
				sb[i - 1] = new StringBuilder(i + "");

			int i = 0;

			while (true) {
				if (sb[i].length() < s.length()) {
					++count;

					sb[i].append(i + 1 + "");
				} else if (sb[i].length() > s.length())
					break;
				else if (sb[i].toString().compareTo(s) <= 0) {
					++count;

					sb[i].append(i + 1 + "");
				} else
					break;

				i = (i + 1) % 9;
			}

			o.println(count);
		}

		o.flush();
		o.close();
	}
}