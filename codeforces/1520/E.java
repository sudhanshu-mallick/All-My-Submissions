import java.util.*;
import java.io.*;

public class Arranging_The_Sheeps {

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
			List<Integer> pos = new ArrayList<>();
			long ans = 0;

			for (int i = 0; i < n; ++i)
				if (ch[i] == '*')
					pos.add(i);

			if (pos.size() > 0) {
				long median = pos.get(pos.size() >> 1);

				for (long v : pos)
					ans += Math.abs(median - v);

				median = pos.size() >> 1;
				ans -= (median + 1) * median >> 1;
				ans -= (pos.size() - median) * (pos.size() - median - 1) >> 1;
			}

			o.println(ans);

		}

		o.flush();
		o.close();
	}
}
