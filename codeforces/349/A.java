import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Cinema_Line {

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
		int p = 0, q = 0, r = 0, flag = 0;
		long sum = 0;

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();
		}

		if (a[0] != 25)
			o.print("NO");
		else {
			for (int i = 0; i < n; i++) {
				if (a[i] == 25) {
					p++;
				} else if (a[i] == 50) {
					if (p > 0)
						p--;
					else {
						flag = 1;
						break;
					}

					q++;
				} else {
					if (q > 0 && p > 0) {
						q--;
						p--;
					} else if (p > 2) {
						p -= 3;
					} else {
						flag = 1;
						break;
					}

					r++;
				}
			}

			if (flag == 0)
				o.print("YES");
			else
				o.print("NO");
		}

		o.flush();
		o.close();

	}

}
