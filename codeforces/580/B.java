import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Kefa_And_Company {

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
		int d = t.nextInt();
		long sum = 0, csum = 0;
		Pair[] a = new Pair[n];

		for (int i = 0; i < n; i++) {
			int x = t.nextInt();
			int y = t.nextInt();
			a[i] = new Pair(x, y);
		}

		Arrays.sort(a);

		int i = 0, j = 0;

		while (j < n) {
			Pair l = a[i];
			Pair r = a[j];

			if ((r.a - l.a) < d) {
				j++;
				csum += r.b;
			} else {
				sum = Math.max(sum, csum);
				csum -= l.b;
				i++;
			}
		}

		sum = Math.max(sum, csum);

		o.println(sum);
		o.flush();
		o.close();
	}

	private static class Pair implements Comparable<Pair> {
		int a;
		int b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair p) {
			return (this.a != p.a) ? (this.a - p.a) : (this.b - p.b);
		}
	}

}