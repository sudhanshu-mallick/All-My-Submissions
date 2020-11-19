import java.util.*;
import java.io.*;

public class SwapSort {

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
		int[] a = new int[n];
		List<int[]> ans = new ArrayList<>();

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();
		}

		for (int i = 0; i < n; ++i) {
			int min = a[i];
			int idx = i;

			for (int k = i + 1; k < n; ++k) {
				if (a[k] < min) {
					min = a[k];
					idx = k;
				}
			}

			if (idx != i) {
				ans.add(new int[] { i, idx });

				int temp = a[i];
				a[i] = a[idx];
				a[idx] = temp;
			}
		}

		o.println(ans.size());

		for (int[] temp : ans) {
			o.println(temp[0] + " " + temp[1]);
		}

		o.flush();
		o.close();
	}
}