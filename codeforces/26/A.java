import java.io.*;
import java.util.*;

public class Almost_Prime {

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
		int count = 0;

		for (int i = 1; i <= n; i++) {
			if (primeFactor(i))
				count++;
		}

		o.println(count);

		o.flush();
		o.close();
	}

	private static boolean primeFactor(int n) {
		HashSet<Integer> map = new HashSet<Integer>();

		while (n % 2 == 0) {
			map.add(2);
			n /= 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				map.add(i);

				n /= i;

				if (map.size() > 2)
					return false;
			}
		}

		if (n > 2 && map.size() == 1)
			return true;

		if (n <= 2 && map.size() == 2)
			return true;
		else
			return false;
	}
}
