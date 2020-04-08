import java.util.*;
import java.io.*;

public class Ehab_Is_An_Odd_Person {

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
		Integer[] a = new Integer[n];
		int flag = 0, parity = 0;

		for (int i = 0; i < n; i++)
			a[i] = t.nextInt();

		if (n == 1) {
			o.println(a[0]);
			o.close();
			return;
		}

		parity = (Math.abs(a[0] - a[1]) & 1);

		for (int i = 0; i < n - 1; i++) {
			int abs=Math.abs(a[i]-a[i+1]);
			if ((abs & 1) != parity) {
				flag = 1;
				break;
			}
		}

		if (flag == 1) {
			Arrays.sort(a);
		}

		for (int i = 0; i < n; i++)
			o.print(a[i] + " ");

		o.flush();
		o.close();
	}
}
