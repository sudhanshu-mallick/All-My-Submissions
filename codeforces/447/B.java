import java.util.*;
import java.io.*;

public class DZY_Loves_String {

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
		String s = t.next();
		int k = t.nextInt();
		int[] a = new int[26];
		int cost = 0;
		int max = 0;

		for (int i = 0; i < 26; ++i) {
			a[i] = t.nextInt();
			max = Math.max(max, a[i]);
		}

		for (int i = 1; i <= s.length(); ++i)
			cost += i * a[s.charAt(i - 1) - 'a'];

		int cur = s.length() + 1;

		while (k-- > 0) {
			cost += max * cur;
			++cur;
		}

		o.println(cost);
		o.flush();
		o.close();
	}
}