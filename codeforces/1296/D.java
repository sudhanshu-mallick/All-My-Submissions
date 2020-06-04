import java.util.*;
import java.io.*;

public class Fight_With_Monster {

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
		int a = t.nextInt();
		int b = t.nextInt();
		int k = t.nextInt();
		int count = 0;
		Integer[] h = new Integer[n];

		for (int i = 0; i < n; ++i) {
			h[i] = t.nextInt();
			h[i] = h[i] % (a + b);

			if (h[i] == 0)
				h[i] = a + b;

			h[i] = (h[i] + a - 1) / a - 1;
		}

		Arrays.sort(h);

		for (int i = 0; i < n; ++i) {
			if (k - h[i] < 0)
				break;

			count++;
			k -= h[i];
		}

		o.println(count);

		o.flush();
		o.close();
	}
}