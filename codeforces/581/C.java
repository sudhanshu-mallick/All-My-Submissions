import java.util.*;
import java.io.*;

public class Developing_Skills {

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
		int[] a = new int[10];
		int[] b = new int[n];
		int max = 0;

		for (int i = 0; i < n; ++i) {
			b[i] = t.nextInt();
			a[b[i] % 10]++;
			max += b[i] / 10;
			b[i] = b[i] % 10 == 0 ? b[i] : b[i] + 10 - b[i] % 10;
		}

		int i = 9;

		while (k > 0 && i > 0) {
			int val = Math.min(k, (10 - i) * a[i]);
			max += val / (10 - i);
			k -= val;
			--i;
		}

		i = 0;

		while (k > 0 && i < n) {
			int val = Math.min(k, 100 - b[i]);
			max += val / 10;
			k -= val;
			++i;
		}

		o.println(max);
		o.close();
	}
}