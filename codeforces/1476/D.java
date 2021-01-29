import java.util.*;
import java.io.*;

public class Journey {

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
			int n = t.nextInt();
			char[] ch = t.next().toCharArray();
			int left[] = new int[n];
			int[] right = new int[n];
			left[0] = right[n - 1] = 1;

			for (int i = 1; i < n; ++i) {
				if (ch[i] != ch[i - 1])
					left[i] = left[i - 1] + 1;
				else
					left[i] = 1;

				if (ch[n - i - 1] != ch[n - i])
					right[n - i - 1] = right[n - i] + 1;
				else
					right[n - i - 1] = 1;
			}

			if (ch[0] == 'R')
				o.print(right[0] + 1 + " ");
			else
				o.print(1 + " ");

			for (int i = 1; i < n; ++i) {
				int cities = 1;

				if (ch[i - 1] == 'L')
					cities += left[i - 1];

				if (ch[i] == 'R')
					cities += right[i];

				o.print(cities + " ");
			}

			if (ch[n - 1] == 'L')
				o.print(left[n - 1] + 1);
			else
				o.print("1");

			o.println();
		}

		o.flush();
		o.close();
	}
}