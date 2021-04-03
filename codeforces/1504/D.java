import java.util.*;
import java.io.*;

public class _3_Coloring {

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
		List<int[]> one = new ArrayList<>();
		List<int[]> two = new ArrayList<>();

		for (int i = 1; i <= n; ++i)
			for (int j = 1; j <= n; ++j)
				if (((i + j) & 1) == 0)
					one.add(new int[] { i, j });
				else
					two.add(new int[] { i, j });

		int i = 0, j = 0;

		while (i < one.size() && j < two.size()) {
			int val = t.nextInt();

			if (val == 1) {
				o.println("2 " + two.get(j)[0] + " " + two.get(j)[1]);
				o.flush();

				++j;
			} else {
				o.println("1 " + one.get(i)[0] + " " + one.get(i)[1]);
				o.flush();

				++i;
			}
		}

		while (i < one.size()) {
			int val = t.nextInt();

			if (val == 1) {
				o.println("3 " + one.get(i)[0] + " " + one.get(i)[1]);
				o.flush();
			} else {
				o.println("1 " + one.get(i)[0] + " " + one.get(i)[1]);
				o.flush();
			}

			++i;
		}

		while (j < two.size()) {
			int val = t.nextInt();

			if (val == 2) {
				o.println("3 " + two.get(j)[0] + " " + two.get(j)[1]);
				o.flush();
			} else {
				o.println("2 " + two.get(j)[0] + " " + two.get(j)[1]);
				o.flush();
			}

			++j;
		}

		o.flush();
		o.close();
	}
}