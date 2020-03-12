import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Pashmak_And_Flowers {

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
		long n = t.nextLong();
		int[] a = new int[(int) n];
		int max = 0, min = Integer.MAX_VALUE;
		long xc = 0, nc = 0;

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();

			if (max < a[i]) {
				max = a[i];
			}

			if (min > a[i]) {
				min = a[i];
			}
		}

		for (int i = 0; i < n; i++) {
			if (a[i] == max)
				xc++;

			if (a[i] == min)
				nc++;
		}

		int ans = max - min;
		long p = 0;

		if (ans == 0) {
			p = (long) (n * (n - 1)) / 2;
		} else {
			p = nc * xc;
		}

		o.println(ans + " " + p);
		o.flush();
		o.close();
	}

}