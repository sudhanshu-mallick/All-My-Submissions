import java.util.*;
import java.io.*;

public class Arrival_Of_The_General {

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
		int max = 0, min = 100;
		int[] a = new int[n];

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();
			max = Math.max(max, a[i]);
			min = Math.min(min, a[i]);
		}

		int left = 0;
		int right = n - 1;

		for (int i = 0; i < n; ++i) {
			if (a[i] == max) {
				left = i;
				break;
			}
		}

		for (int i = n - 1; i >= 0; --i) {
			if (a[i] == min) {
				right = i;
				break;
			}
		}

		if (right > left)
			o.print(n - 1 - right + left);
		else
			o.println(n - 2 - right + left);
		o.flush();
		o.close();
	}
}