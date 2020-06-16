import java.util.*;
import java.io.*;

public class Equal_Sums {

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
		int k = t.nextInt();
		int[][] a = new int[k][];
		int el = 0;
		long sum[] = new long[k];

		for (int i = 0; i < k; ++i) {
			int n = t.nextInt();
			el += n;
			a[i] = new int[n];

			for (int j = 0; j < n; ++j) {
				a[i][j] = t.nextInt();
				sum[i] += a[i][j];
			}
		}

		Pair[] pair = new Pair[el];
		int p = 0;

		for (int i = 0; i < k; ++i) {
			for (int j = 0; j < a[i].length; ++j) {
				pair[p++] = new Pair(i + 1, sum[i] - a[i][j], j + 1);
			}
		}

		Arrays.sort(pair, (Pair x, Pair y) -> (int) (x.sum - y.sum));

		boolean flag = false;
//
//		for (int i = 0; i < el; ++i)
//			System.out.println(pair[i].seq + " " + pair[i].sum + " " + pair[i].idx);

		for (int i = 0; i < el - 1; ++i) {
			if (pair[i].sum == pair[i + 1].sum && pair[i].seq != pair[i + 1].seq) {
				flag = true;
				o.println("YES");
				o.println(pair[i].seq + " " + pair[i].idx);
				o.println(pair[i + 1].seq + " " + pair[i + 1].idx);
				break;
			}
		}

		if (!flag)
			o.println("NO");

		o.flush();
		o.close();
	}

	static class Pair {
		int seq;
		long sum;
		int idx;

		Pair(int seq, long sum, int idx) {
			this.seq = seq;
			this.sum = sum;
			this.idx = idx;
		}
	}
}