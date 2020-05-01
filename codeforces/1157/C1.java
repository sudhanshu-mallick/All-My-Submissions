import java.util.*;
import java.io.*;

public class Increasing_Subsequence {

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
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		int l = 0, h = n - 1, cur = Math.min(a[l], a[h]);

		while (l < h) {
			if (cur <= Math.min(a[l], a[h])) {
				if (a[l] < a[h]) {
					sb.append('L');
					cur = a[l];
					l++;
				} else {
					sb.append('R');
					cur = a[h];
					h--;
				}
			} else if (cur <= Math.max(a[l], a[h])) {
				if (a[l] > a[h]) {
					sb.append('L');
					cur = a[l];
					l++;
				} else {
					sb.append('R');
					cur = a[h];
					h--;
				}
			} else
				break;
		}

		if (l == h && cur <= a[l])
			sb.append('L');

		o.println(sb.length());
		o.println(sb);

		o.flush();
		o.close();
	}
}