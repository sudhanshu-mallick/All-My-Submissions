import java.util.*;
import java.io.*;

public class LCM_Challenge {

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

		if (n == 1)
			o.println(1);
		else if (n == 2)
			o.println(2);
		else if (n == 3)
			o.println(6);
		else {
			if ((n & 1) == 1)
				o.println(n * (n - 1) * (n - 2));
			else {
				if (n % 3 == 0)
					o.println((n - 1) * (n - 2) * (n - 3));
				else
					o.println(n * (n - 1) * (n - 3));
			}
		}

		o.flush();
		o.close();
	}
}