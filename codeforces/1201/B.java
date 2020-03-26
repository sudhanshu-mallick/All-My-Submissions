import java.util.*;
import java.io.*;

public class Zero_Array {

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
		long sum = 0, max = 0;
		boolean flag = false;
		Integer[] a = new Integer[n];

		for (int i = 0; i < n; i++) {
			a[i] = t.nextInt();
			sum += a[i];
			max = Math.max(max, a[i]);
		}

		if (sum % 2 == 0 && max * 2 <= sum)
			o.println("YES");
		else
			o.println("NO");

		o.flush();
		o.close();
	}
}