import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Given_Length {

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
		int s = t.nextInt();
		int sum = s;
		StringBuilder big = new StringBuilder();
		StringBuilder small = new StringBuilder();

		if (s > 9 * n || (s == 0 && n > 1)) {
			o.print(-1 + " " + -1);
			o.close();
		}

		for (int i = 0; i < n; i++) {
			if (sum >= 9) {
				sum -= 9;
				big.append("9");
			} else if (sum < 9) {
				big.append(sum);
				sum = 0;
			}
		}

		small = new StringBuilder(big);
		small.reverse();

		if (small.charAt(0) == '0' && s > 0) {
			small.setCharAt(0, '1');

			for (int i = 1; i < n; i++) {
				if (small.charAt(i) != '0') {
					small.setCharAt(i, (char) ((small.charAt(i)) - 1));
					break;
				}

			}
		}
		o.println(small + " " + big);
		o.close();

	}

}
