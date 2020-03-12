import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Sort_The_Array {

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
		int si = 0, ei = 0, count = 0;

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		for (int i = 0; i < n - 1; i++) {
			if (a[i] < a[i + 1]) {
				if (count == 0) {
					si++;
					ei++;
				} else
					break;
			} else {
				count = 1;
				ei++;
			}

		}

		int k = 0;

		for (int i = si; i <= (si + ei) / 2; i++) {
			int te = a[i];
			a[i] = a[ei - k];
			a[ei - k] = te;
			k++;
		}

		count = 0;

		for (int i = 0; i < n - 1; i++) {
			if (a[i] > a[i + 1]) {
				count = 1;
				break;
			}
		}

		if (count == 1)
			o.println("no");
		else {
			o.println("yes");
			o.println((si + 1) + " " + (ei + 1));
		}

		o.flush();
		o.close();
	}

}
