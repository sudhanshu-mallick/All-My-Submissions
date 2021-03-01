import java.util.*;
import java.io.*;

public class Pekora_And_Trampoline {

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
			long[] a = new long[n];
			long[] depth = new long[n];
			long passes = 0;

			for (int i = 0; i < n; ++i) {
				a[i] = t.nextLong();

				int si = i + 2, ei = (int) Math.min(n, i + a[i] + 1);

				if (si <= ei && si < n)
					++depth[si];

				if (ei < n)
					--depth[ei];
			}

			for (int i = 1; i < n; ++i)
				depth[i] += depth[i - 1];

			for (int i = 0; i < n; ++i) {
				if (a[i] > depth[i])
					passes += a[i] - depth[i] - 1;
				else if (i + 1 < n)
					depth[i + 1] += depth[i] + 1 - a[i];
			}

			o.println(passes);
		}

		o.flush();
		o.close();
	}
}