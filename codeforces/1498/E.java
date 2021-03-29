import java.util.*;
import java.io.*;

public class Two_Houses {

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

	private static FastReader t = new FastReader();
	private static PrintWriter o = new PrintWriter(System.out);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = t.nextInt();
		int[] a = new int[n];
		boolean flag = false;
		List<Pair> list = new ArrayList<>();

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		for (int i = 0; i < n; ++i)
			for (int j = i + 1; j < n; ++j)
				if (a[i] >= a[j])
					list.add(new Pair(i + 1, j + 1, a[i] - a[j]));
				else
					list.add(new Pair(j + 1, i + 1, a[j] - a[i]));

		Collections.sort(list, (x, y) -> y.abs - x.abs);

		for (Pair p : list) {
			String res = query(p.i, p.j);

			if (res.equals("Yes")) {
				flag = true;

				o.println("! " + p.i + " " + p.j);
				break;
			}
		}

		if (!flag)
			o.println("! 0 0");

		o.flush();
		o.close();
	}

	private static String query(int x, int y) {
		o.println("? " + x + " " + y);
		o.flush();

		return t.next();
	}
}

class Pair {
	int i;
	int j;
	int abs;

	Pair(int i, int j, int abs) {
		this.i = i;
		this.j = j;
		this.abs = abs;
	}
}