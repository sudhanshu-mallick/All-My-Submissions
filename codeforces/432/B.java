import java.util.*;
import java.io.*;

public class Football_Kit {

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
		int[][] team = new int[n][2];
		int[][] color = new int[100000][2];

		for (int i = 0; i < n; ++i) {
			team[i][0] = t.nextInt() - 1;
			team[i][1] = t.nextInt() - 1;
			++color[team[i][0]][0];
			++color[team[i][1]][1];
		}

		for (int i = 0; i < n; ++i) {
			int home = n + color[team[i][1]][0] - 1;
			int away = 2 * n - 2 - home;

			o.println(home + " " + away);
		}

		o.flush();
		o.close();
	}
}