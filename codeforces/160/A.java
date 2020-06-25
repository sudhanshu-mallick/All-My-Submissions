import java.util.*;
import java.io.*;

public class Twins {

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
		int sum = 0;
		int[] a = new int[n];

		for (int i = 0; i < n; ++i)
			sum = sum + (a[i] = t.nextInt());

		Arrays.sort(a);

		int mid = sum / 2 + 1;
		int count = 0;
		int cur = 0;
		int i = n - 1;

		while (i >= 0) {
			cur += a[i];
			count++;

			if (cur >= mid)
				break;

			--i;
		}

		o.println(count);

		o.flush();
		o.close();
	}
}