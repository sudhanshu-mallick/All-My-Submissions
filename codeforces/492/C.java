import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Vanya_And_Exams {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int n = t.nextInt();
		int max = t.nextInt();
		long avg = t.nextLong();
		Pair[] p = new Pair[n];
		Compare ob = new Compare();
		long sum = 0;

		for (int i = 0; i < n; i++) {
			int a = t.nextInt();
			int b = t.nextInt();
			p[i] = new Pair(a, b);
			sum += a;
		}

		if (sum / n >= avg) {
			o.println(0);
		} else {
			ob.compare(p, n);

			long tot = avg * n - sum;
			long cost = 0;

			for (int i = 0; i < n; i++) {
				long dif = max - p[i].x;
				cost += Math.min(tot, dif) * p[i].y;
				tot -= dif;

				if (tot <= 0)
					break;
			}

			o.println(cost);
		}

		o.flush();
		o.close();
	}

}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Compare {

	static void compare(Pair a[], int n) {
		Arrays.sort(a, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				return p1.y - p2.y;
			}
		});
	}
}
