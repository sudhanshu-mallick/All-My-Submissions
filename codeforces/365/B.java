import java.util.*;
import java.io.*;

public class The_Fibonnaci_Segment {

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
		int n = t.nextInt(), cur = Math.min(2, n);
		int max = cur;

		int[] a = new int[n];

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		for (int i = 2; i < n; ++i) {
			if (a[i] == a[i - 1] + a[i - 2])
				cur++;
			else {
				max = Math.max(cur, max);
				cur = 2;
			}
		}

		max = Math.max(cur, max);

		o.println(max);

		o.flush();
		o.close();
	}
}