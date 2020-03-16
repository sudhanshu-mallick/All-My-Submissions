import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Make_Them_Equal {

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
		HashSet<Integer> a = new HashSet<>();

		for (int i = 0; i < n; i++) {
			int el = t.nextInt();

			a.add(el);
		}

		if (a.size() == 1) {
			o.println(0);
		} else if (a.size() == 2) {
			int p = 0, q = 0;

			for (int alpha : a) {
				if (p == 0)
					p = alpha;
				else
					q = alpha;
			}

			int diff = Math.abs(p - q);

			if (diff % 2 == 0)
				o.println(diff / 2);
			else
				o.println(diff);
		} else if (a.size() == 3) {
			int p = 0, q = 0, r = 0;
			int[] ok = new int[3];

			for (int alpha : a) {
				if (ok[0] == 0)
					ok[0] = alpha;
				else if (ok[1] == 0)
					ok[1] = alpha;
				else
					ok[2] = alpha;

			}

			Arrays.sort(ok);

			int d1 = ok[1] - ok[0], d2 = ok[2] - ok[1];

			if (d1 == d2)
				o.println(d1);
			else
				o.println(-1);
		} else {
			o.println(-1);
		}

		o.flush();
		o.close();
	}

}
