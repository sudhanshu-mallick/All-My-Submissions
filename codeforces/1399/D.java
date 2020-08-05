import java.util.*;
import java.io.*;

public class Binary_String_To_Subsequence {
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
			int n = t.nextInt();
			char ch[] = t.next().toCharArray();
			int[] a = new int[n];

			Arrays.fill(a, -1);

			for (int i = 0; i < n; ++i) {
				if (ch[i] == '0')
					a[i] = 1;
			}

			int temp = a[0];
			int max = 0;

			for (int i = 1; i < n; ++i) {
				if (ch[i] == '0' && ch[i - 1] == '1')
					a[i] = a[i - 1];
				else if (ch[i] == '1' && ch[i - 1] == '0')
					a[i] = a[i - 1];
				else if (ch[i] == '0' && ch[i - 1] == '0')
					a[i] = a[i - 1] + 1;
				else
					a[i] = a[i - 1] - 1;

				temp = a[i] < temp ? a[i] : temp;
			}

			if (temp <= 0) {
				for (int i = 0; i < n; ++i)
					a[i] = a[i] + 1 - temp;
			}

			for (int i = 0; i < n; ++i)
				max = a[i] > max ? a[i] : max;

			o.println(max);

			for (int i = 0; i < n; ++i)
				o.print(a[i] + " ");

			o.println();
		}

		o.flush();
		o.close();
	}
}