import java.util.*;
import java.io.*;

public class Zero_Quantity_Maximization {

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
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		int count = 0;

		for (int i = 0; i < n; ++i)
			a[i] = t.nextInt();

		for (int i = 0; i < n; ++i) {
			int y = t.nextInt();

			if (a[i] != 0) {
				int gcd = gcd(a[i], y);
				String x = (-a[i] / gcd) + " " + (y / gcd);
				map.put(x, map.getOrDefault(x, 0) + 1);
				max = Math.max(max, map.get(x));
			} else if (y == 0)
				count++;

		}

		o.println(count + max);
		o.flush();
		o.close();
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}