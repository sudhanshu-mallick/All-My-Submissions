import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bear_And_Poker {

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
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();

			while (a[i] > 1) {
				if (a[i] % 3 == 0)
					a[i] /= 3;
				else if (a[i] % 2 == 0)
					a[i] /= 2;
				else
					break;
			}
		}

		int cur = a[0], flag = 0;

		for (int i = 0; i < n; i++) {
			if (a[i] != cur) {
				flag = 1;
				break;
			}
		}

		if (flag == 0)
			o.println("Yes");
		else
			o.println("No");

		o.flush();
		o.close();
	}

}
