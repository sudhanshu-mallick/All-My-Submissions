import java.util.*;
import java.io.*;

public class More_Cowbells {

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
		int k = t.nextInt();
		int[] a = new int[n];
		int cur = n;
		int max = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		int i = n - 1, j = 0;

		while (k > 0 && i >= j) {
			int val = 0;

			if (k * 2 == cur) {
				val = a[j++] + a[i--];
				cur -= 2;
			} else {
				val = a[i--];
				cur--;
			}

			max = Math.max(val, max);
			k--;
		}

		o.println(max);
		o.flush();
		o.close();
	}
}
