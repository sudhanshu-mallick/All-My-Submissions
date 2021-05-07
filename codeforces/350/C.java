import java.util.*;
import java.io.*;

public class Bombs {

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
		int[][] a = new int[n][2];
		List<String> ops = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			a[i][0] = t.nextInt();
			a[i][1] = t.nextInt();
		}

		Arrays.sort(a, (x, y) -> Math.abs(x[0]) + Math.abs(x[1]) - Math.abs(y[0]) - Math.abs(y[1]));

		for (int i = 0; i < n; ++i) {
			int x = a[i][0];
			int y = a[i][1];

			if (x != 0)
				if (x > 0)
					ops.add("1 " + x + " R");
				else
					ops.add("1 " + (-x) + " L");

			if (y != 0)
				if (y > 0)
					ops.add("1 " + y + " U");
				else
					ops.add("1 " + (-y) + " D");

			ops.add("2");

			if (y != 0)
				if (y > 0)
					ops.add("1 " + y + " D");
				else
					ops.add("1 " + (-y) + " U");

			if (x != 0)
				if (x > 0)
					ops.add("1 " + x + " L");
				else
					ops.add("1 " + (-x) + " R");

			ops.add("3");
		}

		o.println(ops.size());

		for (String s : ops)
			o.println(s);

		o.flush();
		o.close();
	}
}