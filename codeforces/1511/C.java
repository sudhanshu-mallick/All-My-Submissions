import java.util.*;
import java.io.*;

public class Yet_Another_Card_Deck {

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
		int q = t.nextInt();
		int[] a = new int[n];
		int[][] pos = new int[50][2];

		for (int i = 0; i < 50; ++i)
			pos[i][0] = -1;

		for (int i = 0; i < n; ++i) {
			int x = t.nextInt() - 1;

			if (pos[x][0] == -1)
				pos[x][0] = i;
		}

		while (q-- > 0) {
			int wanted = t.nextInt() - 1;
			int idx = pos[wanted][0] + pos[wanted][1];

			o.print(pos[wanted][0] + pos[wanted][1] + 1 + " ");

			pos[wanted][0] = 0;
			pos[wanted][1] = 0;

			for (int i = 0; i < 50; ++i) {
				if (i != wanted && pos[i][0] + pos[i][1] < idx)
					++pos[i][1];
			}
		}

		o.flush();
		o.close();
	}
}