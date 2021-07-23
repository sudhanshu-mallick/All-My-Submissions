import java.util.*;
import java.io.*;

public class Wonderful_Coloring_1 {

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

	public static void shuffle(int[] a) {
		Random r = new Random();

		for (int i = 0; i <= a.length - 2; i++) {
			int j = i + r.nextInt(a.length - i);

			swap(a, i, j);
		}

		Arrays.sort(a);
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader t = new FastReader();
		PrintWriter o = new PrintWriter(System.out);
		int test = t.nextInt();

		while (test-- > 0) {
			char ch[] = t.next().toCharArray();
			int cur = 0;
			int n = ch.length;
			int[] color = new int[n];

			Arrays.sort(ch);

			color[0] = 1;

			for (int i = 1; i < n; ++i) {
				if (ch[i] != ch[i - 1]) {
					color[i] = cur;
					cur ^= 1;
				} else {
					if (i > 1 && ch[i] == ch[i - 2]) {
						color[i] = -1;
					} else {
						color[i] = cur;
						cur ^= 1;
					}
				}
			}

			int one = 0, two = 0;

			for (int v : color) {
				if (v == 1)
					++one;
				else if (v == 0)
					++two;
			}

			o.println(Math.min(one, two));

		}

		o.flush();
		o.close();
	}
}