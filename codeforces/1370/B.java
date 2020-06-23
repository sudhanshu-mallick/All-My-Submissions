
import java.util.*;
import java.io.*;

public class GCD_Compression {

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
		int test = t.nextInt();

		while (test-- > 0) {
			List<Integer> odd = new ArrayList<>();
			List<Integer> even = new ArrayList<>();
			int n = t.nextInt();

			for (int i = 0; i < 2 * n; ++i) {
				int x = t.nextInt();

				if ((x & 1) == 1)
					odd.add(i + 1);
				else
					even.add(i + 1);
			}

			int i = 0, j = 0, count = 0;

			while (count < n - 1) {
				if (i <= odd.size() - 2) {
					o.println(odd.get(i) + " " + odd.get(i + 1));
					i += 2;
					count++;
				} else {
					o.println(even.get(j) + " " + even.get(j + 1));
					count++;
					j += 2;
				}
			}
		}

		o.flush();
		o.close();
	}
}