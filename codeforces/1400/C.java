import java.util.*;
import java.io.*;

public class Binary_String_Reconstruction {

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
		int test = t.nextInt();

		while (test-- > 0) {
			String s = t.next();
			int k = t.nextInt();
			int n = s.length();
			int[] a = new int[n];

			Arrays.fill(a, -1);

			for (int i = 0; i < n; ++i) {
				if (s.charAt(i) == '0') {
					if (i + k < n)
						a[i + k] = 0;

					if (i - k >= 0)
						a[i - k] = 0;
				}
			}

			for (int i = 0; i < n; ++i)
				if (a[i] == -1)
					a[i] = 1;

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < n; ++i) {
				int v1 = i + k < n ? a[i + k] : 0;
				int v2 = i - k >= 0 ? a[i - k] : 0;
				int v = v1 | v2;

				sb.append(v + "");
			}

			if (sb.toString().equals(s)) {
				for (int i = 0; i < n; ++i)
					o.print(a[i]);

				o.println();
			} else {
				o.println("-1");
			}
		}

		o.flush();
		o.close();
	}
}