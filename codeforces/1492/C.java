
import java.util.*;
import java.io.*;

public class Maximum_Widht {

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
		int m = t.nextInt();
		int n = t.nextInt();
		char[] a = t.next().toCharArray();
		char[] b = t.next().toCharArray();
		int[] left = new int[m];
		int[] right = new int[m];
		int i = 0, j = 0;

		while (j < n) {
			while (a[i] != b[j]) {
				++i;
			}

			left[j++] = i++;
		}

		i = m - 1;
		j = n - 1;

		while (j >= 0) {
			while (a[i] != b[j]) {
				--i;
			}

			right[j--] = i--;
		}

		int max = 0;

		for (i = 0; i < m - 1; ++i) {
			max = Math.max(max, right[i + 1] - left[i]);
		}

		o.println(max);
		o.flush();
		o.close();
	}
}