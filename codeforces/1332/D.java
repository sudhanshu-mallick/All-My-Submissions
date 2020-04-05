import java.io.*;
import java.util.*;

public class Walk_On_Matrix {

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
		int k = t.nextInt();

		if (k == 0)
			o.println(1 + " " + 1 + "\n" + 1);
		else {
			long one18 = (1 << 18) - 1;
			long one17 = 1 << 17;

			o.println(3 + " " + 3);
			o.println(one18 + " " + one18 + " " + one17);
			o.println(one18 + " " + k + " " + (one17 + k));
			o.println(one17 + " " + (one17 + k) + " " + k);
		}

		o.flush();
		o.close();
	}
}