import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Product_Of_Three_Numbers {

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
		int test = t.nextInt();

		while (test-- > 0) {
			int n = t.nextInt();
			ArrayList<Integer> a = factor(n);
			int p = a.get(0), q = 1, r = 1;
			int i = 1, flag = 0;

			while (i < a.size()) {
				if (flag == 0) {
					q *= a.get(i);

					if (q != p)
						flag = 1;
				} else {
					r *= a.get(i);
				}

				i++;
			}

			if (flag < 1 || q == r || q == 1 || p == 1 || r == 1 || p == r || p == q)
				o.println("NO");
			else {
				o.println("YES");
				o.println(p + " " + q + " " + r);
			}
		}

		o.flush();
		o.close();
	}

	private static ArrayList<Integer> factor(int n) {
		ArrayList<Integer> a = new ArrayList<>();

		while (n % 2 == 0) {
			a.add(2);
			n /= 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				a.add(i);
				n /= i;
			}
		}

		if (n > 2)
			a.add(n);

		return a;
	}

}
