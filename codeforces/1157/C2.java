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

		int l = 0, h = n - 1, cur = 0, flag = 0;

		if (n == 1) {
			o.println(1);
			o.println('L');
			o.close();
			return;
		}

		if (a[l] < a[h]) {
			cur = a[l];
			sb.append('L');
			l++;
		} else if (a[h] < a[l]) {
			cur = a[h];
			sb.append('R');
			h--;
		} else {
			flag = 1;
		}

		while (l < h && flag == 0) {
			if (cur < Math.min(a[l], a[h])) {
				if (a[l] < a[h]) {
					sb.append('L');
					cur = a[l];
					l++;
				} else if (a[h] < a[l]) {
					sb.append('R');
					cur = a[h];
					h--;
				} else {
					flag = 1;
					break;
				}
			} else if (cur < Math.max(a[l], a[h])) {
				if (a[l] > a[h]) {
					sb.append('L');
					cur = a[l];
					l++;
				} else if (a[h] > a[l]) {
					sb.append('R');
					cur = a[h];
					h--;
				} else {
					flag = 1;
					break;
				}
			} else
				break;
		}

		if (l == h && cur < a[l])
			sb.append('L');

		if (flag == 1) {
			int c1 = 1, c2 = 1;
			while (a[l] < a[l + 1]) {
				l++;
				c1++;
			}

			while (a[h] < a[h - 1]) {
				h--;
				c2++;
			}

			if (c1 < c2) {
				while (c2-- > 0)
					sb.append('R');
			} else
				while (c1-- > 0)
					sb.append('L');

		}

		o.println(sb.length());
		o.println(sb);

		o.flush();
		o.close();
	}
}
