
import java.util.*;
import java.io.*;

public class Painting_Pebbles {

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
		int k = t.nextInt();
		int[] a = new int[n];
		int min = 100, max = 1;

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();
			min = min > a[i] ? a[i] : min;
			max = max > a[i] ? max : a[i];
		}

		if (max - min <= k) {
			o.println("YES");

			for (int i = 0; i < n; ++i) {
				int j = 0;

				while (j < a[i]) {
					o.print(j % k + 1 + " ");
					++j;
				}

				o.println();
			}
		} else {
			o.println("NO");
		}

		o.flush();
		o.close();
	}
}
