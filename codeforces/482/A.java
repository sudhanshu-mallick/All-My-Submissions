import java.util.*;
import java.io.*;

public class Diverse_Permutation {

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
		int k = t.nextInt();
		int i = 1, cur = 1, chance = 1;

		while (i <= k) {
			if ((chance & 1) == 1) {
				o.print(cur + " ");

				cur = n - cur + 1;
			} else {
				o.print(cur + " ");

				cur = n - cur + 2;
			}

			chance = 1 - chance;
			i++;
		}

		if ((k & 1) == 0) {
			cur = n - cur + 1;

			while (i <= n) {
				o.print(cur + " ");
				i++;
				cur--;
			}
		} else {
			cur = n - cur + 2;

			while (i <= n) {
				o.print(cur + " ");
				i++;
				cur++;
			}
		}

		o.flush();
		o.close();
	}
}