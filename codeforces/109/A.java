import java.util.*;
import java.io.*;

public class Lucky_Sum_Of_Digits {

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
		int four = 0, seven = 0;

		while (n >= 0) {
			if (n % 7 == 0) {
				seven = n / 7;
				break;
			}

			n -= 4;
			four++;
		}

		if (n < 0)
			o.println(-1);
		else {
			while (four-- > 0)
				o.print("4");

			while (seven-- > 0)
				o.print("7");

			o.println();
		}

		o.flush();
		o.close();
	}
}