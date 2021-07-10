import java.util.*;
import java.io.*;

public class Alphabetical_Strings {

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
			char[] ch = t.next().toCharArray();
			int n = ch.length;
			int left = -1, right = -1;

			for (int i = 0; i < n; ++i) {
				if (ch[i] == 'a') {
					left = right = i;
					break;
				}
			}

			if (left == -1) {
				o.println("NO");
			} else {
				char cur = 'b';

				while (true) {
					if (left - 1 >= 0 && ch[left - 1] == cur) {
						--left;
						++cur;
					} else if (right + 1 < n && ch[right + 1] == cur) {
						++cur;
						++right;
					} else {
						break;
					}
				}

				if (right - left == n - 1)
					o.println("YES");
				else
					o.println("NO");
			}
		}

		o.flush();
		o.close();
	}
}