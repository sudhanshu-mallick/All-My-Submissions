import java.util.*;
import java.io.*;

public class PriceFixed {

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
		long cost = 0;
		Pair[] pair = new Pair[n];
		long taken = 0;

		for (int i = 0; i < n; ++i)
			pair[i] = new Pair(t.nextLong(), t.nextLong());

		Arrays.sort(pair, (x, y) -> x.discount == y.discount ? Double.compare(x.req, y.req)
				: Double.compare(x.discount, y.discount));

		int i = 0, j = n - 1;

		while (i <= j) {
			if (pair[j].req + taken >= pair[i].discount) {
				long cur = taken >= pair[i].discount ? 0 : (pair[i].discount - taken);
				cost += cur * 2;
				pair[j].req -= cur;
				taken += cur;

				if (pair[j].req == 0)
					--j;

				taken += pair[i].req;
				cost += pair[i].req;
				pair[i].req = 0;
				++i;
			} else {
				long cur = Math.min(pair[j].req, pair[i].discount - taken);
				cost += cur * 2;
				pair[j].req -= cur;
				taken += cur;

				if (pair[j].req == 0)
					--j;
			}
		}

		o.println(cost);
		o.flush();
		o.close();
	}
}

class Pair {
	long req;
	long discount;

	Pair(long req, long discount) {
		this.req = req;
		this.discount = discount;
	}
}