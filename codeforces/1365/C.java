import java.util.*;
import java.io.*;

public class Rotation_Matching {

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
		int b[] = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		int max = 0;

		for (int i = 0; i < n; ++i) {
			a[i] = t.nextInt();
			c[a[i] - 1] = i;
		}

		for (int i = 0; i < n; ++i) {
			b[i] = t.nextInt();
			int idx = (c[b[i] - 1] - i + n) % n;
			d[idx]++;

		}

		for (int i = 0; i < n; ++i)
			max = Math.max(d[i], max);

		o.println(max);

		o.flush();
		o.close();
	}
}