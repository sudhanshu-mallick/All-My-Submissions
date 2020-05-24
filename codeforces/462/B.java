import java.util.*;
import java.io.*;

public class Appleman_And_Cardgame {

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
		long k = t.nextLong();
		long[] a = new long[26];
		String s = t.next();
		long cost = 0;

		for (int i = 0; i < n; ++i)
			a[s.charAt(i) - 'A']++;

		Arrays.sort(a);

		int i = 25;

		while (i >= 0 && k > 0) {
			if (a[i] <= k)
				cost += a[i] * a[i];
			else
				cost += k * k;

			k -= a[i];
			i--;
		}

		o.println(cost);

		o.flush();
		o.close();
	}
}