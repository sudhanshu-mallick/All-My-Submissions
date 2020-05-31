import java.util.*;
import java.io.*;

public class Quasi_Binary {

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
		int size = 1;
		String s = Integer.toBinaryString(1);
		int val = Integer.parseInt(s);

		while (val <= n) {
			size++;
			s = Integer.toBinaryString(size);
			val = Integer.parseInt(s);
		}

		size--;
		int a[] = new int[size];

		for (int i = 0; i < size; ++i) {
			int num = i + 1;
			a[i] = Integer.parseInt(Integer.toBinaryString(num));
		}

		int N = a.length;
		int[] count = new int[n + 1];
		int[] from = new int[n + 1];
		count[0] = 1;

		for (int i = 0; i < n; i++)
			if (count[i] > 0)
				for (int j = 0; j < N; j++) {
					int p = i + a[j];
					if (p <= n) {
						if (count[p] == 0 || count[p] > count[i] + 1) {
							count[p] = count[i] + 1;
							from[p] = j;
						}
					}
				}

		int[] result = new int[count[n] - 1];
		int k = n;

		while (k > 0) {
			result[count[k] - 2] = a[from[k]];
			k = k - a[from[k]];
		}

		o.println(result.length);

		for (int i = 0; i < result.length; ++i)
			o.print(result[i] + " ");

		o.flush();
		o.close();
	}
}