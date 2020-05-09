import java.util.*;
import java.io.*;

public class Tile_Painting {

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
		List<Long> l = new ArrayList<>();

		if (n == 1)
			o.println("1");
		else {
			if (n % 2 == 0)
				l.add(2l);

			while (n % 2 == 0)
				n /= 2;

			for (long i = 3; i * i <= n; i += 2) {
				if (n % i == 0) {
					l.add(i);

					while (n % i == 0)
						n /= i;
				}
			}

			if (n > 1)
				l.add(n);

			if (l.size() > 1)
				o.println("1");
			else
				o.println(l.get(0));
		}

		o.flush();
		o.close();
	}
}