import java.util.*;
import java.io.*;

public class Interesting_Story {

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
			Pair[] pair = new Pair[n];
			int max = 0;

			for (int i = 0; i < n; ++i)
				pair[i] = new Pair(t.next());

			for (int k = 0; k < 5; ++k)
				max = Math.max(max, getCurMax(pair, k));

			o.println(max);

		}

		o.flush();
		o.close();
	}

	private static class Pair {
		String s;
		int[] count;
		int[] dif;

		Pair(String s) {
			this.s = s;
			int n = s.length();
			count = new int[5];
			dif = new int[5];

			for (char ch : s.toCharArray())
				++count[ch - 'a'];

			for (int i = 0; i < 5; ++i)
				dif[i] = count[i] - (n - count[i]);
		}
	}

	private static int getCurMax(Pair[] pair, int k) {
		Arrays.sort(pair, (x, y) -> y.dif[k] - x.dif[k]);

		int i = 0, need = 0, notNeed = 0, n = pair.length;

		while (i < n) {
			int curNeed = pair[i].count[k];
			int curNotNeed = pair[i].s.length() - curNeed;

			if (need + curNeed > notNeed + curNotNeed) {
				need += curNeed;
				notNeed += curNotNeed;
			} else
				break;

			++i;
		}

		return i;
	}
}