import java.util.*;
import java.io.*;

public class Lets_Go_Hiking {

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
		int n = t.nextInt();
		int[] a = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];
		int max = 0;
		int count = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		for (int i = 1; i < n; ++i) {
			if (a[i] > a[i - 1])
				left[i] = left[i - 1] + 1;

			if (a[n - i - 1] > a[n - i])
				right[n - i - 1] = right[n - i] + 1;

			max = Math.max(max, Math.max(left[i], right[n - i - 1]));
		}

		for (int i = 0; i < n; ++i) {
			if (left[i] == max)
				++count;

			if (right[i] == max)
				++count;
		}

		if (count > 2)
			o.println("0");
		else {
			count = 0;

			for (int i = 0; i < n; ++i) {
				if (left[i] == right[i] && left[i] == max && (max & 1) == 0)
					++count;
			}

			o.println(count);
		}

		o.flush();
		o.close();
	}
}