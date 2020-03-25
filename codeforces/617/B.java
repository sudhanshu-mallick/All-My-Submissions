import java.io.*;
import java.util.*;

public class Chocolate {

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
		long ans = 1, c = 0, flag = 0;

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		for (int i = 0; i < n; i++) {
			if (a[i] == 1 && flag == 1) {
				ans *= (c + 1);
				c = 0;
			} else if (a[i] == 1 && flag == 0) {
				c = 0;
				flag = 1;
			} else {
				c++;
			}
		}

		if (flag == 1)
			o.println(ans);
		else
			o.println(0);

		o.flush();
		o.close();
	}

}