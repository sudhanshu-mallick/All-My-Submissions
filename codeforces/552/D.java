import java.util.*;
import java.io.*;

public class Vanya_And_Triangles {

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
		int n = t.nextInt(), count = 0;
		int[] x = new int[n], y = new int[n];

		for (int i = 0; i < n; i++) {
			x[i] = t.nextInt();
			y[i] = t.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int dx = x[j] - x[i];
				int dy = y[j] - y[i];

				for (int k = j + 1; k < n; k++) {
					if (dx * y[k] - dy * x[k] != dx * y[i] - dy * x[i]) {
						count++;
					}
				}
			}
		}

		o.println(count);
		o.flush();
		o.close();
	}
}