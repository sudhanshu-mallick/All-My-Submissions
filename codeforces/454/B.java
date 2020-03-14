import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Sort_By_Shift {

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
		int[] a = new int[n];
		int change = 0, element = 0;

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		for (int i = 0; i < n - 1; i++) {
			if (a[i] > a[i + 1]) {
				change++;
				element = i;
			}

			if (change > 1) {
				System.out.println(-1);
				return;
			}
		}

		if (change == 1) {
			if (a[n - 1] > a[0])
				o.println(-1);
			else {
				o.println(n - element - 1);
			}
		} else
			o.println(0);

		o.flush();
		o.close();

	}

}
