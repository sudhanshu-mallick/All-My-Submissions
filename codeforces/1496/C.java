import java.util.*;
import java.io.*;

public class Diamond_Miner {

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
			List<Double> x = new ArrayList<>();
			List<Double> y = new ArrayList<>();
			double ans = 0;
			n <<= 1;

			while (n-- > 0) {
				int a = t.nextInt();
				int b = t.nextInt();

				if (a == 0)
					y.add((double) (Math.abs(b)));
				else
					x.add((double) (Math.abs(a)));
			}

			Collections.sort(x);
			Collections.sort(y);

			for (int i = 0; i < x.size(); ++i)
				ans += Math.sqrt(x.get(i) * x.get(i) + y.get(i) * y.get(i));

			o.println(ans);
		}

		o.flush();
		o.close();
	}
}
