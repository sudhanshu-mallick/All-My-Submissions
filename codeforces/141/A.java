import java.util.*;
import java.io.*;

public class Amusing_Joke {

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
		int[] cnt = new int[26];
		String s = t.next();

		for (char ch : s.toCharArray())
			++cnt[ch - 'A'];

		s = t.next();

		for (char ch : s.toCharArray())
			++cnt[ch - 'A'];

		s = t.next();

		for (char ch : s.toCharArray())
			--cnt[ch - 'A'];

		boolean flag = true;

		for (int v : cnt) {
			if (v != 0) {
				flag = false;
				break;
			}
		}

		o.println(flag ? "YES" : "NO");

		o.flush();
		o.close();
	}
}