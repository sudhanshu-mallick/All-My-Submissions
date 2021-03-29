import java.util.*;
import java.io.*;

public class Pocket_Book {

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
		int m = t.nextInt();
		int n = t.nextInt();
		char[][] ch = new char[m][n];
		long ans = 1, mod = 1_000_000_007;

		for (int i = 0; i < m; ++i) {
			String s = t.next();

			for (int j = 0; j < n; ++j)
				ch[i][j] = s.charAt(j);
		}

		for (int j = 0; j < n; ++j) {
			Set<Character> set = new HashSet<>();

			for (int i = 0; i < m; ++i)
				set.add(ch[i][j]);

			ans = (ans * set.size()) % mod;
		}

		o.println(ans);
		o.flush();
		o.close();
	}
}