import java.util.*;
import java.io.*;

public class Binary_Removals {

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
			int n = ch.length;
			int zero = 0, one = 0;
			boolean flag = true;
			int idx = n;

			for (int i = 0; i < n - 1; ++i) {
				if (ch[i] == '1' && ch[i + 1] == '1') {
					idx = i + 2;
					break;
				}
			}

			for (int i = idx; i < n - 1; ++i) {
				if (ch[i] == '0' && ch[i + 1] == '0') {
					flag = false;
					break;
				}
			}

			o.println(flag ? "YES" : "NO");
		}

		o.flush();
		o.close();
	}
}