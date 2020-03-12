import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Constanzes_Magazine {

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
		String s = t.next();
		int n = s.length();
		long[] a = new long[n + 1];
		a[0] = a[1] = 1;
		int flag = 0;

		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'w' || s.charAt(i) == 'm') {
				flag = 1;
				break;
			}
		}

		if (flag == 1)
			o.print(0);
		else {
			for (int i = 2; i <= n; i++) {
				if (s.charAt(i - 1) == s.charAt(i - 2) && (s.charAt(i - 1) == 'u' || s.charAt(i - 1) == 'n'))
					a[i] = (a[i - 1] + a[i - 2]) % 1000000007;
				else
					a[i] = a[i - 1];
			}

			o.println(a[n]);
		}

		o.flush();
		o.close();
	}

}